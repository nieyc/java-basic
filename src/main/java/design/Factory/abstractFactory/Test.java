package design.Factory.abstractFactory;
//https://www.zhihu.com/question/20367734
/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:04 2018/3/2
 * @Description 抽象工厂模式
 * 抽象工厂模式也就是不仅生产鼠标，同时生产键盘。
 * 也就是PC厂商是个父类，有生产鼠标，生产键盘两个接口。
 * 戴尔工厂，惠普工厂继承它，可以分别生产戴尔鼠标+戴尔键盘，和惠普鼠标+惠普键盘。
 * 创建工厂时，由戴尔工厂创建。
 **/
public class Test {

    public static void main(String[] args) {
        PcFactory pcFactory=new DellFactory();
        KeyBoard keyBoard=  pcFactory.createKeyBoard();
        Mouse mouse=pcFactory.createMouse();
        keyBoard.SayHi();
        mouse.SayHi();
    }
}
