package design.Factory.FactoryMethod.mouse;



/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 11:01 2018/3/2
 * @Description
 **/
public class DellMouseFactory extends MouseFactory {

    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
