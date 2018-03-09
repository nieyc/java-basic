package design.Adapter;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:37 2018/3/1
 * @Description
 **/
public class DBSocket implements  DBSocketInterface {
    @Override
    public void powerWithTwoRound() {
        System.out.println("使用两项圆头的插孔供电");
    }
}
