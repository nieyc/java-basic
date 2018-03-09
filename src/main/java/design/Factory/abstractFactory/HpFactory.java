package design.Factory.abstractFactory;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:02 2018/3/2
 * @Description
 **/
public class HpFactory extends    PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HpKeyBoard();
    }
}
