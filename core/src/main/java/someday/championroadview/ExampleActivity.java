package someday.championroadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class ExampleActivity extends AppCompatActivity
{

    private GuildChampionRoadView mGuildChampionRoadView1;
    private GuildChampionRoadView mGuildChampionRoadView2;
    private GuildChampionRoadView mGuildChampionRoadView3;
    private GuildChampionRoadView mGuildChampionRoadView4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGuildChampionRoadView1 = (GuildChampionRoadView) findViewById(R.id.guildchampionroadview1);
        mGuildChampionRoadView2 = (GuildChampionRoadView) findViewById(R.id.guildchampionroadview2);
        mGuildChampionRoadView3 = (GuildChampionRoadView) findViewById(R.id.guildchampionroadview3);
        mGuildChampionRoadView4 = (GuildChampionRoadView) findViewById(R.id.guildchampionroadview4);
        test3();
        test4();
        test1();
        test2();
    }

    public void test1()
    {
        Position[] positions = new Position[16];
        for(int i = 1 ; i < 17 ; i++)
        {
            positions[i-1] = new Position("公会"+i,"http://bpic.588ku.com/element_origin_min_pic/00/27/14/5756d13237e9951.jpg",Position.LEVEL_1,Position.Promotion_Status_Standby,i);
        }
        positions[0].level = Position.LEVEL_1;
        positions[0].promotionStatus = Position.Promotion_Status_Lost;
        positions[15].level = Position.LEVEL_2;
        positions[15].promotionStatus = Position.Promotion_Status_Lost;

        positions[7].level = Position.LEVEL_4;
        positions[7].promotionStatus = Position.Promotion_Status_Standby;
        positions[8].level = Position.LEVEL_1;
        positions[8].promotionStatus = Position.Promotion_Status_Lost;

        positions[3].level = Position.LEVEL_1;
        positions[3].promotionStatus = Position.Promotion_Status_Lost;
        positions[12].level = Position.LEVEL_2;
        positions[12].promotionStatus = Position.Promotion_Status_Lost;

        positions[4].level = Position.LEVEL_3;
        positions[4].promotionStatus = Position.Promotion_Status_Lost;
        positions[11].level = Position.LEVEL_1;
        positions[11].promotionStatus = Position.Promotion_Status_Lost;


        positions[1].level = Position.LEVEL_1;
        positions[1].promotionStatus = Position.Promotion_Status_Lost;
        positions[14].level = Position.LEVEL_3;
        positions[14].promotionStatus = Position.Promotion_Status_Lost;

        positions[6].level = Position.LEVEL_1;
        positions[6].promotionStatus = Position.Promotion_Status_Lost;
        positions[9].level = Position.LEVEL_2;
        positions[9].promotionStatus = Position.Promotion_Status_Lost;

        positions[2].level = Position.LEVEL_1;
        positions[2].promotionStatus = Position.Promotion_Status_Lost;
        positions[13].level = Position.LEVEL_2;
        positions[13].promotionStatus = Position.Promotion_Status_Lost;

        positions[5].level = Position.LEVEL_4;
        positions[5].promotionStatus = Position.Promotion_Status_Standby;
        positions[10].level = Position.LEVEL_1;
        positions[10].promotionStatus = Position.Promotion_Status_Lost;
        mGuildChampionRoadView1.setGuildPositions(positions);
    }

    public void test2()
    {
        Position[] positions = new Position[16];
        for(int i = 1 ; i < 17 ; i++)
        {
            positions[i-1] = new Position("公会"+i,"http://bpic.588ku.com/element_origin_min_pic/00/27/14/5756d13237e9951.jpg",Position.LEVEL_1,Position.Promotion_Status_Standby,i);
        }
        positions[0].level = Position.LEVEL_2;
        positions[0].promotionStatus = Position.Promotion_Status_Lost;
        positions[15] = null;

        positions[7].level = Position.LEVEL_4;
        positions[7].promotionStatus = Position.Promotion_Status_Lost;
        positions[8].level = Position.LEVEL_1;
        positions[8].promotionStatus = Position.Promotion_Status_Lost;

        positions[3].level = Position.LEVEL_1;
        positions[3].promotionStatus = Position.Promotion_Status_Lost;
        positions[12].level = Position.LEVEL_2;
        positions[12].promotionStatus = Position.Promotion_Status_Lost;

        positions[4].level = Position.LEVEL_3;
        positions[4].promotionStatus = Position.Promotion_Status_Lost;
        positions[11].level = Position.LEVEL_1;
        positions[11].promotionStatus = Position.Promotion_Status_Lost;


        positions[1].level = Position.LEVEL_3;
        positions[1].promotionStatus = Position.Promotion_Status_Lost;
        positions[14] = null;

        positions[6].level = Position.LEVEL_1;
        positions[6].promotionStatus = Position.Promotion_Status_Lost;
        positions[9].level = Position.LEVEL_2;
        positions[9].promotionStatus = Position.Promotion_Status_Lost;

        positions[2].level = Position.LEVEL_1;
        positions[2].promotionStatus = Position.Promotion_Status_Lost;
        positions[13].level = Position.LEVEL_2;
        positions[13].promotionStatus = Position.Promotion_Status_Lost;

        positions[5].level = Position.LEVEL_4;
        positions[5].promotionStatus = Position.Promotion_Status_Win;
        positions[10].level = Position.LEVEL_1;
        positions[10].promotionStatus = Position.Promotion_Status_Lost;
        mGuildChampionRoadView2.setGuildPositions(positions);
    }
    public void test3()
    {
        Position[] positions = new Position[16];
        for(int i = 1 ; i < 17 ; i++)
        {
            positions[i-1] = new Position("公会"+i,"http://bpic.588ku.com/element_origin_min_pic/00/27/14/5756d13237e9951.jpg",Position.LEVEL_1,Position.Promotion_Status_Standby,i);
        }
        positions[15] = null;
        positions[14] = null;

        mGuildChampionRoadView3.setGuildPositions(positions);
    }

    public void test4()
    {
        Position[] positions = new Position[16];
        for(int i = 1 ; i < 17 ; i++)
        {
            positions[i-1] = new Position("公会"+i,"http://bpic.588ku.com/element_origin_min_pic/00/27/14/5756d13237e9951.jpg",Position.LEVEL_1,Position.Promotion_Status_Standby,i);
        }
        positions[0].level = Position.LEVEL_2;
        positions[0].promotionStatus = Position.Promotion_Status_Standby;
        positions[15] = null;

        positions[7].level = Position.LEVEL_2;
        positions[7].promotionStatus = Position.Promotion_Status_Standby;
        positions[8].level = Position.LEVEL_1;
        positions[8].promotionStatus = Position.Promotion_Status_Lost;

        positions[3].level = Position.LEVEL_1;
        positions[3].promotionStatus = Position.Promotion_Status_Lost;
        positions[12].level = Position.LEVEL_2;
        positions[12].promotionStatus = Position.Promotion_Status_Standby;

        positions[4].level = Position.LEVEL_2;
        positions[4].promotionStatus = Position.Promotion_Status_Standby;
        positions[11].level = Position.LEVEL_1;
        positions[11].promotionStatus = Position.Promotion_Status_Lost;


        positions[1].level = Position.LEVEL_2;
        positions[1].promotionStatus = Position.Promotion_Status_Standby;
        positions[14] = null;

        positions[6].level = Position.LEVEL_1;
        positions[6].promotionStatus = Position.Promotion_Status_Lost;
        positions[9].level = Position.LEVEL_2;
        positions[9].promotionStatus = Position.Promotion_Status_Standby;

        positions[2].level = Position.LEVEL_1;
        positions[2].promotionStatus = Position.Promotion_Status_Lost;
        positions[13].level = Position.LEVEL_2;
        positions[13].promotionStatus = Position.Promotion_Status_Standby;

        positions[5].level = Position.LEVEL_2;
        positions[5].promotionStatus = Position.Promotion_Status_Standby;
        positions[10].level = Position.LEVEL_1;
        positions[10].promotionStatus = Position.Promotion_Status_Lost;
        mGuildChampionRoadView4.setGuildPositions(positions);
    }

    public void test6()
    {
        Position[] positionsLeft = new Position[8];
//        positionsLeft[0] = new Position(Position.LEVEL_2, Position.Promotion_Status_Lost,0);
        positionsLeft[0] = null;
        positionsLeft[1] = new Position(Position.LEVEL_2, Position.Promotion_Status_Lost,1);
        positionsLeft[2] = new Position(Position.LEVEL_1, Position.Promotion_Status_Lost,2);
        positionsLeft[3] = new Position(Position.LEVEL_4, Position.Promotion_Status_Win,3);
        positionsLeft[4] = new Position(Position.LEVEL_1, Position.Promotion_Status_Lost,4);
        positionsLeft[5] = new Position(Position.LEVEL_3, Position.Promotion_Status_Lost,5);
        positionsLeft[6] = new Position(Position.LEVEL_1, Position.Promotion_Status_Lost,6);
        positionsLeft[7] = new Position(Position.LEVEL_2, Position.Promotion_Status_Lost,7);

        Position[] positionsRight = new Position[8];
        positionsRight[0] = new Position(Position.LEVEL_1, Position.Promotion_Status_Lost,0);
        positionsRight[1] = new Position(Position.LEVEL_4, Position.Promotion_Status_Lost,1);
        positionsRight[2] = new Position(Position.LEVEL_2, Position.Promotion_Status_Lost,2);
        positionsRight[3] = new Position(Position.LEVEL_1, Position.Promotion_Status_Lost,3);
        positionsRight[4] = new Position(Position.LEVEL_3, Position.Promotion_Status_Lost,4);
        positionsRight[5] = new Position(Position.LEVEL_1, Position.Promotion_Status_Lost,5);
        positionsRight[6] = new Position(Position.LEVEL_2, Position.Promotion_Status_Lost,6);
        positionsRight[7] = new Position(Position.LEVEL_1, Position.Promotion_Status_Lost,7);

        //mChampionRoadViewLeft.setGuildPositions(positionsLeft);
        //mChampionRoadViewRight.setGuildPositions(positionsRight);
    }
}
