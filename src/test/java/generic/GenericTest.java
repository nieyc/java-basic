package generic;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:18 2018/6/13
 * @Description 泛型方法
 **/
public class GenericTest {

     /**
       @Author:nieyc
       @Description: 一个真正的泛型方法，首先 public 和 T 之间的  <T>  是必须的，这表明这是一个泛型方法，并且声明了一个泛型T
                      这个T可以出现在这个泛型方法的任意位置。
                       这个泛型方法可以返回任意类型（基础类型除外，如int），如Integer,Boolean ,String
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




    public static void main(String[] args) {
        GenericTest test=new GenericTest();
        Generic<Integer> g=new Generic<Integer>(123);
        test.showKeyName(g);

        Generic<String> g1=new Generic<String>("love wenwen");
        test.showKeyName(g1);

        Generic<Boolean> g2=new Generic<Boolean>(true);
        test.showKeyName(g2);

        //泛型方法和可变参数测试

        test.printMsg("111",222,"aaaa","2323.4",55.55,true);


    }
}
