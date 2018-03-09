package design.Factory.FactoryMethod;
//http://blog.csdn.net/lemon_tree12138/article/details/46225213

import design.Factory.FactoryMethod.car.BusFactory;
import design.Factory.FactoryMethod.car.CarFactory;
import design.Factory.FactoryMethod.car.MotoFactory;
import design.Factory.FactoryMethod.car.Moveable;
import design.Factory.FactoryMethod.mouse.DellMouseFactory;
import design.Factory.FactoryMethod.mouse.HpMouseFactory;
import design.Factory.FactoryMethod.mouse.Mouse;
import design.Factory.FactoryMethod.mouse.MouseFactory;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:50 2018/3/1
 * @Description 工厂模式
 * 说明：分为工厂和产品两个部分
 * 工厂端： 首先定义一个抽象的工厂，然后有多个具体的工厂继承抽象工厂，并实现抽象工厂里的方法，假设2个工厂A,B
 * 产品端： 产品a,b,c 实现接口1，产品d,e 实现接口2
 * 工厂和产品关系：A工厂生产产品a，b，c; B工厂生产产品d，e
 * 更多参考 见 http://blog.csdn.net/lemon_tree12138/article/details/46225213
 *
 **/
public class Test {
    public static void main(String[] args) {
        CarFactory factory =new MotoFactory();
        CarFactory carFactory=new BusFactory();
        Moveable moveable = factory.create();
        moveable.run();
        Moveable busMoveable = carFactory.create();
        busMoveable.run();
        System.out.println("******************************");
        MouseFactory mf=new DellMouseFactory();
        Mouse m= mf.createMouse();
        m.SayHi();
        MouseFactory mf1=new HpMouseFactory();
        Mouse m1= mf1.createMouse();
        m1.SayHi();

    }




}
