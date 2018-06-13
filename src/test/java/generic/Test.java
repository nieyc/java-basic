package generic;

import java.util.ArrayList;
import java.util.List;
//https://blog.csdn.net/s10461/article/details/53941091/
/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:54 2018/6/13
 * @Description
 **/
public class Test {

     /**
       @Author:nieyc
       @Description: 测试一个带有泛型通配符参数的方法
       @Date:17:01 2018/6/13
      **/
    public static void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试:"+"key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        //泛型类测试--start
        Generic<Integer> genericInteger= new Generic<Integer>(123);
        System.out.println(genericInteger.getKey());
        Generic<String> genericString= new Generic<String>("may be liliwen?");
        System.out.println(genericString.getKey());
        Generic g1=new Generic(20.5);
        System.out.println(g1.getKey());
        Generic g2=new Generic(false);
        System.out.println(g2.getKey());


        //泛型接口测试----start
        Generator<String> g=new FruitGenerator();
        String fruitName=g.next();
        System.out.println("水果名称："+fruitName);

        //测试泛型通配符---start
        //Number 和Integer 均可以传入
        Generic<Number> genericNumber= new Generic<Number>(123);
        showKeyValue1(genericNumber);
        Generic<Integer> g3= new Generic<Integer>(888);
        showKeyValue1(g3);
    }
}
