package design.Factory.FactoryMethod.car;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:54 2018/3/1
 * @Description
 **/
public class BusFactory implements CarFactory {
    @Override
    public Moveable create() {
        return new Bus();
    }
}
