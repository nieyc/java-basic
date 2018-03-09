package design.Factory.simpleFactory.car;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:14 2018/3/1
 * @Description
 **/
public class Factory {
    public static Car driverCar(String carName){
        if("benz".equals(carName)){
            return  new Benz();
        }else if("bmw".equals(carName)){
            return  new Bmw();
        }else{
            return null;
        }
    }
}
