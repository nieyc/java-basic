package design.Factory.simpleFactory;

import design.Factory.simpleFactory.car.Car;
import design.Factory.simpleFactory.car.Factory;
import design.Factory.simpleFactory.mouse.Mouse;
import design.Factory.simpleFactory.mouse.MouseFactory;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:18 2018/3/1
 * @Description 简单工厂模式
 * 鼠标工厂，专业生产鼠标，给定参数0生产dell鼠标，给定参数1 生产hp鼠标，就是这么简单
 **/
public class Test {
    public static void main(String[] args) {
        Car car= Factory.driverCar("bmw");
        car.drive();
        System.out.println("----------------分隔符---------------------");
        Mouse mouse=MouseFactory.createMouse(0);
        mouse.SayHi();


    }
}
