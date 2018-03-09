package design.Adapter;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:40 2018/3/1
 * @Description
 **/
public class GBSocket implements GBSocketInterface {
    @Override
    public void powerWithThreeFlat() {
        System.out.println("使用三项扁头插孔供电");
    }
}
