package design.Adapter;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:39 2018/3/1
 * @Description
 **/
public class Hotel {
    //旅馆中有一个德标的插口
    private DBSocketInterface dbSocket;

    public Hotel(){}

    public Hotel(DBSocketInterface dbSocket) {
        this.dbSocket = dbSocket;
    }

    public void setSocket (DBSocketInterface dbSocket){
        this.dbSocket = dbSocket;
    }

    //旅馆中有一个充电的功能
    public void charge(){

        //使用德标插口充电
        dbSocket.powerWithTwoRound();
    }

    public static void main(String[] args) {
        //初始化一个德国插座对象， 用一个德标接口引用它
        DBSocketInterface dbSoket = new DBSocket();
        Hotel hotel=new Hotel(dbSoket);
        hotel.charge();
    }
}
