package someday.championroadview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 公会进级线路图控件
 * 基本原理是定义横向和纵向坐标以及间距，作为定位，如下图示例：
 *
 *    1      2      3      4      5      6　　Ｙ坐标　把view宽分为5等份,共６个标记位
 * 1  ********
 * 2         ********
 * 3  ********      *
 * 4                ********
 * 5  ********      *      *
 * 6         ********      *
 * 7  ********             *
 * 8                       ***************
 * 9  ********             *
 * 10        ********      *
 * 11 ********      *      *
 * 12               ********
 * 13 ********      *
 * 14        ********
 * 15 ********
 *
 * X坐标　把view高度分为14等份,共15个标记位
 *
 * 然后把对应的xy坐标位置计算好并放入数组中 {@link #initializeSpacing}
 * 在绘制线路时遍历使用 {@link #drawLine}
 * 其中把[位置]定义为类,统一管理 {@link Position}
 *
 * Created by jie on 16-9-12.
 */
public class ChampionRoadView extends View
{
    public ChampionRoadView(Context context) {
        super(context);
        initialize(null);
    }

    public ChampionRoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    public ChampionRoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(attrs);
    }

    private static final int MODE_LEFT = 0;
    private static final int MODE_RIGHT = 1;
    private int MODE = MODE_LEFT;
    private Paint mDefaultPaint;
    private Paint mLostPaint;
    private Paint mWinPaint;
    private int DefaultPaintStrokeWidth = 4;
    private int LightPaintStrokeWidth = 2;
    private int mDefaultVerticalSpacingSupplement;
    private int mLightVerticalSpacingSupplement;
    private Position[] mPositions;
    private int mWidth = 0;
    private int mHeight = 0;
    private float[][] mVerticalSpacingArray;
    private float[] mHorizontalSpacingArray;

    public void initialize(AttributeSet attrs)
    {
        if(null != attrs)
        {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ChampionRoadView);
            MODE = typedArray.getInt(R.styleable.ChampionRoadView_mode, MODE_LEFT);
            typedArray.recycle();
        }
        DefaultPaintStrokeWidth = dip2px(DefaultPaintStrokeWidth);
        LightPaintStrokeWidth = dip2px(LightPaintStrokeWidth);

        mDefaultPaint = new Paint();
        mDefaultPaint.setColor(Color.parseColor("#2c323e"));
        mDefaultPaint.setStrokeWidth(DefaultPaintStrokeWidth);

        mLostPaint = new Paint();
        mLostPaint.setColor(Color.parseColor("#574832"));
        mLostPaint.setStrokeWidth(LightPaintStrokeWidth);

        mWinPaint = new Paint();
        mWinPaint.setColor(Color.parseColor("#ff9c00"));
        mWinPaint.setStrokeWidth(LightPaintStrokeWidth);
    }

    public int dip2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    /**
     *
     * @param positions 必须是长度为８位的数组，可以内含空值
     */
    public void setGuildPositions(Position[] positions)
    {
        if(positions.length != 8)
            throw new RuntimeException("guildPositions　list length not is 8");
        mPositions = positions;


        /**
         * 先冒泡排序，把level低的或是空的排到前面，先进先绘制，避免低等级的线条复盖高等级线条
         */
        for(int j=7;j > 0;j--)
        {
            for(int i=0;i < j;i++)
            {
                if(null == mPositions[i] || null == mPositions[i+1] || mPositions[i].level > mPositions[i+1].level)
                {
                    Position temp = mPositions[i];
                    mPositions[i] = mPositions[i+1];
                    mPositions[i+1] = temp;
                }
            }
        }

    }



    @Override
    protected void onDraw(Canvas canvas)
    {
        if(0 == mWidth)
        {
            initializeSpacing();
        }
        initDefaultLine(canvas);
        initChampionroadLine(canvas);
    }
    /**
     * 初始化最底部的基线
     * @param canvas
     */
    private void initDefaultLine(Canvas canvas)
    {
        drawLine(Position.LEVEL_4,0,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
        drawLine(Position.LEVEL_1,1,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
        drawLine(Position.LEVEL_2,2,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
        drawLine(Position.LEVEL_1,3,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
        drawLine(Position.LEVEL_3,4,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
        drawLine(Position.LEVEL_1,5,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
        drawLine(Position.LEVEL_2,6,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
        drawLine(Position.LEVEL_1,7,canvas,mDefaultPaint,mDefaultVerticalSpacingSupplement,Position.Promotion_Status_Standby);
    }

    private void initChampionroadLine(Canvas canvas)
    {
        if (null != mPositions)
        {
            for (Position position : mPositions)
            {
                if(null != position)
                    drawLineByPosition(position,canvas);
            }
        }

    }

    private void drawLineByPosition(Position position,Canvas canvas)
    {


        Paint paint ;
        if(position.Promotion_Status_Lost == position.promotionStatus && position.level == Position.LEVEL_1)
            paint = mDefaultPaint;
        else
            paint = position.promotionStatus != Position.Promotion_Status_Lost?mWinPaint:mLostPaint;
        drawLine(position.level,position.position,canvas,paint,mLightVerticalSpacingSupplement,position.promotionStatus);
    }

    /**
     * 按照层级level绘制线路
     * @param level
     * @param position
     * @param canvas
     * @param paint
     * @param verticalSpacingSupplement 转角空缺填充宽度
     */
    private void drawLine(int level,int position,Canvas canvas,Paint paint,float verticalSpacingSupplement,int status)
    {
        if(MODE == MODE_RIGHT)
            verticalSpacingSupplement = -verticalSpacingSupplement;

        for(int i =0;i <= level; i++)
        {
            int tempNextIndex = i+1;

            if(!(status == Position.Promotion_Status_Lost && i == level))
            {
                if((Position.LEVEL_4+1) > (tempNextIndex))
                    canvas.drawLine(mHorizontalSpacingArray[tempNextIndex],  mVerticalSpacingArray[i][position],mHorizontalSpacingArray[tempNextIndex], mVerticalSpacingArray[tempNextIndex][position],paint);

            }
            canvas.drawLine(mHorizontalSpacingArray[i]+ (i!=Position.LEVEL_1 ? -verticalSpacingSupplement:0),
                    mVerticalSpacingArray[i][position],mHorizontalSpacingArray[tempNextIndex] + verticalSpacingSupplement,
                    mVerticalSpacingArray[i][position],paint);

        }

    }

    private void initializeSpacing()
    {

        mWidth = getWidth();
        mHeight = getHeight();

        float mHorizontalSpacing = mWidth/4;
        float mVerticalSpacing = (mHeight-DefaultPaintStrokeWidth)/14f;
        Log.d("ChampionRoadView",String.valueOf(mVerticalSpacing));
        Log.d("ChampionRoadView",String.valueOf(mHeight)+"-"+String.valueOf(DefaultPaintStrokeWidth));
        /**
         * 用于填补转角位接驳时由于线粗的半个差值做成的缺角情况,例如下面这种情况
         * **********************
         * ************************
         * ************************
         *                      ***
         *                      ***
         *                      ***
         */
        mDefaultVerticalSpacingSupplement = DefaultPaintStrokeWidth / 2;
        mLightVerticalSpacingSupplement = LightPaintStrokeWidth / 2;


        float mVerticalSpacing2Times = mVerticalSpacing * 2;
        float mVerticalSpacing3Times = mVerticalSpacing * 3;
        float mVerticalSpacing4Times = mVerticalSpacing * 4;
        float mVerticalSpacing7Times = mVerticalSpacing * 7;
        float mVerticalSpacing8Times = mVerticalSpacing * 8;

        if(MODE == MODE_LEFT)
            mHorizontalSpacingArray = new float[]{0,mHorizontalSpacing,mHorizontalSpacing * 2,mHorizontalSpacing * 3,mWidth};
        else
            mHorizontalSpacingArray = new float[]{mWidth,mHorizontalSpacing * 3,mHorizontalSpacing * 2,mHorizontalSpacing,0};

        float mPosition_x_1_1 = DefaultPaintStrokeWidth/2;
        float mPosition_x_1_2 = mPosition_x_1_1 + mVerticalSpacing2Times;
        float mPosition_x_1_3 = mPosition_x_1_2 + mVerticalSpacing2Times;
        float mPosition_x_1_4 = mPosition_x_1_3 + mVerticalSpacing2Times;
        float mPosition_x_1_5 = mPosition_x_1_4 + mVerticalSpacing2Times;
        float mPosition_x_1_6 = mPosition_x_1_5 + mVerticalSpacing2Times;
        float mPosition_x_1_7 = mPosition_x_1_6 + mVerticalSpacing2Times;
        float mPosition_x_1_8 = mPosition_x_1_7 + mVerticalSpacing2Times;
        float[] mLinePosition_x_1 = new float[]{mPosition_x_1_1,mPosition_x_1_2,mPosition_x_1_3,mPosition_x_1_4,mPosition_x_1_5,mPosition_x_1_6,mPosition_x_1_7,mPosition_x_1_8};

        float mPosition_x_2_1 = mVerticalSpacing  + mDefaultVerticalSpacingSupplement;
        float mPosition_x_2_2 = mPosition_x_2_1 + mVerticalSpacing4Times;
        float mPosition_x_2_3 = mPosition_x_2_2 + mVerticalSpacing4Times;
        float mPosition_x_2_4 = mPosition_x_2_3 + mVerticalSpacing4Times;
        float[] mLinePosition_x_2 = new float[]{mPosition_x_2_1,mPosition_x_2_1,mPosition_x_2_2,mPosition_x_2_2,mPosition_x_2_3,mPosition_x_2_3,mPosition_x_2_4,mPosition_x_2_4};

        float mPosition_x_3_1 = mVerticalSpacing3Times;
        float mPosition_x_3_2 = mPosition_x_3_1 + mVerticalSpacing8Times;
        float[] mLinePosition_x_3 = new float[]{mPosition_x_3_1,mPosition_x_3_1,mPosition_x_3_1,mPosition_x_3_1,mPosition_x_3_2,mPosition_x_3_2,mPosition_x_3_2,mPosition_x_3_2};
        float mPosition_x_4_1 = mVerticalSpacing7Times;

        mVerticalSpacingArray = new float[][]{mLinePosition_x_1,mLinePosition_x_2,mLinePosition_x_3,new float[]{mPosition_x_4_1,mPosition_x_4_1,mPosition_x_4_1,mPosition_x_4_1,mPosition_x_4_1,mPosition_x_4_1,mPosition_x_4_1,mPosition_x_4_1},new float[]{mWidth,mWidth,mWidth,mWidth,mWidth,mWidth,mWidth,mWidth}};

    }


}


