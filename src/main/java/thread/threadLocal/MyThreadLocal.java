package thread.threadLocal;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:53 2018/1/17
 * @Description
 * @see https://www.cnblogs.com/dolphin0520/p/3920407.html
 **/
public class MyThreadLocal  {

    ThreadLocal<Long> longLocal=new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal=new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    /**
     @Author:nieyc
     @Description: 一个静态内部类
     @Date:19:08 2018/1/17
     @see ：http://blog.csdn.net/sted_zxz/article/details/76959200
     **/
    static  class myLocal implements  Runnable{
        private  String innerName;
        public myLocal(String threadName){
            this.innerName=threadName;
        }
        @Override
        public void run() {
            MyThreadLocal myTl=new MyThreadLocal();
            myTl.set();
            System.out.println("myTl.getLong():"+myTl.getLong());
            System.out.println("myTl.getString():"+myTl.getString());

        }
    }



    public static void main(String[] args) {
        MyThreadLocal myTl=new MyThreadLocal();
       // myTl.set();
        System.out.println("myTl.getLong():"+myTl.getLong());
        System.out.println("myTl.getString():"+myTl.getString());
        MyThreadLocal.myLocal ta=new MyThreadLocal.myLocal("A");
        Thread thread=new Thread(ta);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("myTl.getLong():"+myTl.getLong());
        System.out.println("myTl.getString():"+myTl.getString());
    }


}
