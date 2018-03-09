package design.Factory.simpleFactory.car;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:12 2018/3/1
 * @Description
 **/
public class Benz implements Car {
    @Override
    public void drive() {
        System.out.println("开奔驰");
    }
}
