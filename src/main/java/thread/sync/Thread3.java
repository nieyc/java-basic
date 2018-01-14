package thread.sync;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description synchronized 可以修饰方法块，也可以修饰方法
 **/
public class Thread3 {
    
    /**
     @Author:nieyc
     @Description:
     @Date:11:18 2018/1/12
     **/
    public void test(){
        synchronized (this){
            int i=5;
            while (i>0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                i--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     @Author:nieyc
     @Description: public synchronized void testNosync() 也可以作为同步类
     @Date:13:45 2018/1/12
     **/
    public  void testNosync(){
            int i=5;
            while (i>0){
                System.out.println(Thread.currentThread().getName()+":" + i);
                i--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }


    public static void main(String[] args) {
        final Thread3 t3=new Thread3();
        Thread t1 = new Thread(  new Runnable() {  public void run() {  t3.test();  }}, "t1"  );
        Thread t2 = new Thread(  new Runnable() {  public void run() {  t3.testNosync();}}, "t2"  );
        t1.start();
        t2.start();
    }
}



