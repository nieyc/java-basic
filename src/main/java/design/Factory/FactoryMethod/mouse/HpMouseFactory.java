package design.Factory.FactoryMethod.mouse;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:59 2018/3/2
 * @Description
 **/
public class HpMouseFactory extends MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
