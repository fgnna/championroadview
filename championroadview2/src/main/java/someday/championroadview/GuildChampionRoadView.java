package someday.championroadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * 公会16强进级图
 * Created by jie on 16-10-10.
 */

public class GuildChampionRoadView extends RelativeLayout
{
    private LinearLayout mGuildsLeft;
    private LinearLayout mGuildsRight;
    private ImageView[] mGuildIconViews;
    private TextView[] mGuildNameViews;
    private ChampionRoadView mChampionRoadViewLeft;
    private ChampionRoadView mChampionRoadViewRight;

    public GuildChampionRoadView(Context context) {
        super(context);
        initialize();
    }

    public GuildChampionRoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public GuildChampionRoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize()
    {
        inflate(getContext(),R.layout.guild_championroad_layout,this);
        mGuildsLeft = (LinearLayout) findViewById(R.id.championroadview_guilds_left);
        mGuildsRight = (LinearLayout) findViewById(R.id.championroadview_guilds_right);
        mChampionRoadViewLeft = (ChampionRoadView) findViewById(R.id.championroadview_left);
        mChampionRoadViewRight = (ChampionRoadView) findViewById(R.id.championroadview_right);
        initGuildItemView();
    }

    private void initGuildItemView()
    {
        mGuildNameViews = new TextView[]{
                (TextView) mGuildsLeft.getChildAt(0).findViewById(R.id.guild_name), //1
                (TextView) mGuildsRight.getChildAt(0).findViewById(R.id.guild_name),//2
                (TextView) mGuildsRight.getChildAt(4).findViewById(R.id.guild_name),//3
                (TextView) mGuildsLeft.getChildAt(4).findViewById(R.id.guild_name),//4
                (TextView) mGuildsLeft.getChildAt(6).findViewById(R.id.guild_name),//5
                (TextView) mGuildsRight.getChildAt(6).findViewById(R.id.guild_name),//6
                (TextView) mGuildsRight.getChildAt(2).findViewById(R.id.guild_name),//7
                (TextView) mGuildsLeft.getChildAt(2).findViewById(R.id.guild_name),//8
                (TextView) mGuildsLeft.getChildAt(3).findViewById(R.id.guild_name),//9
                (TextView) mGuildsRight.getChildAt(3).findViewById(R.id.guild_name),//10
                (TextView) mGuildsRight.getChildAt(7).findViewById(R.id.guild_name),//11
                (TextView) mGuildsLeft.getChildAt(7).findViewById(R.id.guild_name),//12
                (TextView) mGuildsLeft.getChildAt(5).findViewById(R.id.guild_name),//13
                (TextView) mGuildsRight.getChildAt(5).findViewById(R.id.guild_name),//14
                (TextView) mGuildsRight.getChildAt(1).findViewById(R.id.guild_name),//15
                (TextView) mGuildsLeft.getChildAt(1).findViewById(R.id.guild_name) //16
        };
        mGuildIconViews = new ImageView[]{
                (ImageView) mGuildsLeft.getChildAt(0).findViewById(R.id.guild_icon), //1
                (ImageView) mGuildsRight.getChildAt(0).findViewById(R.id.guild_icon),//2
                (ImageView) mGuildsRight.getChildAt(4).findViewById(R.id.guild_icon),//3
                (ImageView) mGuildsLeft.getChildAt(4).findViewById(R.id.guild_icon),//4
                (ImageView) mGuildsLeft.getChildAt(6).findViewById(R.id.guild_icon),//5
                (ImageView) mGuildsRight.getChildAt(6).findViewById(R.id.guild_icon),//6
                (ImageView) mGuildsRight.getChildAt(2).findViewById(R.id.guild_icon),//7
                (ImageView) mGuildsLeft.getChildAt(2).findViewById(R.id.guild_icon),//8
                (ImageView) mGuildsLeft.getChildAt(3).findViewById(R.id.guild_icon),//9
                (ImageView) mGuildsRight.getChildAt(3).findViewById(R.id.guild_icon),//10
                (ImageView) mGuildsRight.getChildAt(7).findViewById(R.id.guild_icon),//11
                (ImageView) mGuildsLeft.getChildAt(7).findViewById(R.id.guild_icon),//12
                (ImageView) mGuildsLeft.getChildAt(5).findViewById(R.id.guild_icon),//13
                (ImageView) mGuildsRight.getChildAt(5).findViewById(R.id.guild_icon),//14
                (ImageView) mGuildsRight.getChildAt(1).findViewById(R.id.guild_icon),//15
                (ImageView) mGuildsLeft.getChildAt(1).findViewById(R.id.guild_icon) //16
        };
    }

    /**
     * 传入16名对面成员
     * @param positions 不能为空,length必须等于16,但充许其中的单个数据为空
     */
    public void setGuildPositions(Position[] positions)
    {
        if(null == positions || 16 != positions.length )
            throw new RuntimeException("param non-compliant");

        initGuildInfo(positions);
        initGuildChampionRoadView(positions);

    }


    private void initGuildInfo(Position[] positions)
    {
        for(int i = 0; i < 16; i++)
        {
            if(null != positions[i])
            {
                mGuildNameViews[i].setText(positions[i].name);
                Glide.with(getContext()).load(positions[i].icon).into(mGuildIconViews[i]);
            }
        }

    }

    private void initGuildChampionRoadView(Position[] positions)
    {
        Position[] positionsLeft = new Position[8];
//        positionsLeft[0] = new Position(Position.LEVEL_2, Position.Promotion_Status_Lost,0);
        positionsLeft[0] = positions[0];
        setPositionIndex(positionsLeft[0],0);
        positionsLeft[1] = positions[15];
        setPositionIndex(positionsLeft[1],1);
        positionsLeft[2] = positions[7];
        setPositionIndex(positionsLeft[2],2);
        positionsLeft[3] = positions[8];
        setPositionIndex(positionsLeft[3],3);
        positionsLeft[4] = positions[3];
        setPositionIndex(positionsLeft[4],4);
        positionsLeft[5] = positions[12];
        setPositionIndex(positionsLeft[5],5);
        positionsLeft[6] = positions[4];
        setPositionIndex(positionsLeft[6],6);
        positionsLeft[7] = positions[11];
        setPositionIndex(positionsLeft[7],7);

        Position[] positionsRight = new Position[8];
        positionsRight[0] = positions[1];
        setPositionIndex(positionsRight[0],0);
        positionsRight[1] = positions[14];
        setPositionIndex(positionsRight[1],1);
        positionsRight[2] = positions[6];
        setPositionIndex(positionsRight[2],2);
        positionsRight[3] = positions[9];
        setPositionIndex(positionsRight[3],3);
        positionsRight[4] = positions[2];
        setPositionIndex(positionsRight[4],4);
        positionsRight[5] = positions[13];
        setPositionIndex(positionsRight[5],5);
        positionsRight[6] = positions[5];
        setPositionIndex(positionsRight[6],6);
        positionsRight[7] = positions[10];
        setPositionIndex(positionsRight[7],7);

        mChampionRoadViewLeft.setGuildPositions(positionsLeft);
        mChampionRoadViewRight.setGuildPositions(positionsRight);
    }

    private void setPositionIndex(Position position,int positionIndex)
    {
        if(null != position)
            position.position = positionIndex;
    }
}
