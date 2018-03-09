package design.Factory.abstractFactory;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:03 2018/3/2
 * @Description
 **/
public class DellFactory extends  PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new DellKeyBoard();

    }
}
