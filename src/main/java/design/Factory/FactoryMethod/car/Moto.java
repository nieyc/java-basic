package design.Factory.FactoryMethod.car;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:49 2018/3/1
 * @Description
 **/
public class Moto implements  Moveable {
    @Override
    public void run() {
        System.out.println("我是摩托车，我在跑");
    }
}
