package design.Factory.FactoryMethod.car;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:55 2018/3/1
 * @Description
 **/
public class Bus implements  Moveable {
    @Override
    public void run() {
        System.out.println("我是公交车，我在跑");
    }
}
