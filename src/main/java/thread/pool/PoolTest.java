package thread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:20 2018/1/15
 * @Description
 **/
public class PoolTest implements  Runnable{
    private String name;

    public PoolTest(String threadName){
        this.name="thread"+threadName;
    }
    @Override
    public void run() {
        System.out.println( name +" Start. Time = "+new Date());
        processCommand();
        System.out.println( name +" End. Time = "+new Date());
    }

    public  void processCommand(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     @Author:nieyc
     @Description:创建了一个固定大小的线程池，同一时刻只能有5个线程运行
     @Date:15:50 2018/1/15
     **/
    public static void testFixedThreadPool() {
        System.out.println("Main: Starting at: "+ new Date());
        ExecutorService exec= Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            exec.execute(new PoolTest(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        System.out.println("Main: Finished all threads at"+ new Date());
    }

    /**
     @Author:nieyc
     @Description:
     1、主线程的执行与线程池里的线程分开，有可能主线程结束了，但是线程池还在运行
     2、放入线程池的线程并不一定会按其放入的先后而顺序执行
     @Date:15:49 2018/1/15
     **/
    public static void testCachedThreadPool() {
        System.out.println("Main: Starting at: "+ new Date());
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            exec.execute(new PoolTest(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        System.out.println("Main: Finished all threads at"+ new Date());
    }

    /**
     @Author:nieyc
     @Description:创建只能运行一条线程的线程池。它能保证线程的先后顺序执行，
                    并且能保证一条线程执行完成后才开启另一条新的线程
     @Date:15:48 2018/1/15
     **/
    public static void testSingleThreadPool() {
        System.out.println("Main Thread: Starting at: "+ new Date());
        ExecutorService exec = Executors.newSingleThreadExecutor();   //创建大小为1的固定线程池
        for(int i = 0; i < 10; i++) {
            exec.execute(new PoolTest(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        System.out.println("Main Thread: Finished at:"+ new Date());
    }

    /**
     @Author:nieyc
     @Description: 线程延迟执行
     @Date:15:47 2018/1/15
     **/
    public  static  void testScheduledThreadPool(){
        System.out.println("Main Thread: Starting at: "+ new Date());
       // ExecutorService exec=Executors.newScheduledThreadPool(10);
        ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        for(int i = 0; i < 10; i++) {
            exec.schedule(new PoolTest(String.valueOf(i)), 10, TimeUnit.SECONDS);
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        while(!exec.isTerminated()){
            //wait for all tasks to finish
        }
        System.out.println("Main Thread: Finished at:"+ new Date());
    }

    public static void main(String[] args) {
        //testFixedThreadPool();
        //System.out.println("------------------------------------");
        //testCachedThreadPool();
        //testSingleThreadPool();
        testScheduledThreadPool();
    }
}
