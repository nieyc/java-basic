package generic;




/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:18 2018/6/13
 * @Description 泛型方法
 * JDK 文档中各符号的含义： T：类型K：键V：值E：元素（如集合类中的元素全部用该符号表示）N：Number
 **/
public class GenericTest {

     /**
       @Author:nieyc
       @Description: 一个真正的泛型方法，首先 public 和 T 之间的  <T>  是必须的，这表明这是一个泛型方法，并且声明了一个泛型T
                      这个T可以出现在这个泛型方法的任意位置。
                       这个泛型方法可以返回任意引用类型（基础类型除外，如int），如Integer,Boolean ,String
       @Date:17:25 2018/6/13
      **/
    public  <T> T showKeyName(Generic<T> container){
        System.out.println("container.key:"+container.getKey());
        T test = container.getKey();
        return test;
    }


     /**
       @Author:nieyc
       @Description: 泛型方法和可变参数
       @Date:17:34 2018/6/13
      **/
    public  <T> void printMsg(T... args){
          for(T t:args){
              System.out.println("入参为："+t);
          }
    }


     /**
       @Author:nieyc
       @Description:上通配符，extends 关键字，指定了传入的类型实参必须是 Number 类或 Number 类的子类
       @Date:10:20 2018/6/14
      **/
    public void showKeyValue1(Generic<? extends Number> obj){
        System.out.println(("泛型测试"+"key value is " + obj.getKey()));
    }

     /**
       @Author:nieyc
       @Description: 下限通配符 super 关键字，指定了传入的类型实参必须是 Integer 类或 Integer 类的父类
       @Date:10:52 2018/6/14
      **/
    public void showKeyValue2(Generic<? super Integer> obj){
        System.out.println(("泛型测试super"+"key value is " + obj.getKey()));
    }




    public static void main(String[] args) {
        GenericTest test=new GenericTest();
        Generic<Integer> g=new Generic<Integer>(123);
        test.showKeyName(g);

        Generic<String> g1=new Generic<String>("love wenwen");
        test.showKeyName(g1);

        Generic<Boolean> g2=new Generic<Boolean>(true);
        test.showKeyName(g2);

        Generic<Integer> g3=new Generic<Integer>(1);
        test.showKeyValue1(g3);

        Generic<Number> g4=new Generic<Number>(1l);
        test.showKeyValue2(g4);


        //泛型方法和可变参数测试

        test.printMsg("111",222,"aaaa","2323.4",55.55,true);


    }
}
