package design.SingleTon;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:22 2018/1/15
 * @Description
 **/
public class SingleObject {
    private static SingleObject ourInstance = null;

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject() {
    }

    /**
     @Author:nieyc
     @Description: 单例模式注意必须是线程安全的
     @Date:9:31 2018/1/15
     **/
    public static synchronized SingleObject getInstance() {
        if(ourInstance==null) {
            ourInstance = new SingleObject();
        }
        return ourInstance;
    }

    public static void main(String[] args) {
        System.out.println( getInstance());
        //获取当前系统的CPU 数目
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuNums);
    }


}
