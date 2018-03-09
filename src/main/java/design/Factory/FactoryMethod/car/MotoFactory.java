package design.Factory.FactoryMethod.car;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:48 2018/3/1
 * @Description
 **/
public class MotoFactory implements CarFactory {
    @Override
    public Moveable create() {
        return new Moto();
    }
}
