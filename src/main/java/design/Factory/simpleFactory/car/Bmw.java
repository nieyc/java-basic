package design.Factory.simpleFactory.car;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:13 2018/3/1
 * @Description
 **/
public class Bmw implements Car {
    @Override
    public void drive() {
        System.out.println("开宝马");
    }
}
