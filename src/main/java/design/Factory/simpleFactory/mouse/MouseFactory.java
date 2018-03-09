package design.Factory.simpleFactory.mouse;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:13 2018/3/2
 * @Description
 **/
public class MouseFactory {

    public static Mouse  createMouse(int i){
        if(i==0){
            return new DellMouse();
        }else if(i==1){
            return new HpMouse();
        }else{
            return null;
        }

    }

}
