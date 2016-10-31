package someday.championroadview;

/**
 * 排位实体类
 * Created by jie on 16-9-18.
 */
public class Position
{
    public static final int LEVEL_1 = 0;//16强
    public static final int LEVEL_2 = 1;//8强
    public static final int LEVEL_3 = 2;//4强
    public static final int LEVEL_4 = 3;//决赛

    public static final int Promotion_Status_Standby = 1;
    public static final int Promotion_Status_Lost = 2;
    public static final int Promotion_Status_Win = 3;



    public int level;//进级阶段
    public int promotionStatus;//进级状态
    public int position;//位置　从0开始纵向排列
    public String name;//公会名
    public String icon;//公会icon
    public String id;//公会id

    public Position(int level, int promotionStatus, int position)
    {
        this.level = level;
        this.promotionStatus = promotionStatus;
        this.position = position;
    }
    public Position(String name,String icon,int level, int promotionStatus, int position)
    {
        this.name = name;
        this.icon = icon;
        this.level = level;
        this.promotionStatus = promotionStatus;
        this.position = position;
    }

}