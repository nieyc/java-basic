package thread.sync;

/**
 @Author:nieyc
 @Description:
 @Date:11:21 2018/1/12
 **/
public class Thread1 implements  Runnable {

    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" 没有加同步锁的线程:"+i);
        }

    }

    /**
     @Author:nieyc
     @Description: 没有同步锁的2个线程，执行的时候没有先后顺序
     @Date:11:20 2018/1/12
     **/
    public static void main(String[] args) {
        Thread1 t1=new Thread1();
        Thread ta=new Thread(t1,"A");
        ta.start();
        Thread tb=new Thread(t1,"B");
        tb.start();
    }


}
