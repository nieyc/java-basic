package design.Adapter;

//http://blog.csdn.net/zhangjg_blog/article/details/18735243#reply
/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 18:25 2018/2/28
 * @Description
 **/
public class TestAdapter  {

    public static void main(String[] args) {
        GBSocketInterface gbSocket = new GBSocket();

        Hotel hotel = new Hotel();

        SocketAdapter socketAdapter = new SocketAdapter(gbSocket);

        hotel.setSocket(socketAdapter);

        hotel.charge();

        //##################################################
        System.out.println("***************第二种实现方法*******************");
        DBSocketInterface gbSocket1=new SocketAdapter1();
        gbSocket1.powerWithTwoRound();
    }
}
