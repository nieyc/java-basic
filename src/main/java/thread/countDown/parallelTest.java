package thread.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:43 2018/7/3
 * @Description：并行测试
 * 实现多个线程开始执行任务的最大并行性,注意是并行性，不是并发，
 * 强调的是多个线程在某一时刻同时开始执行。类似于赛跑，将多个线程放到起点，
 * 等待发令枪响，然后同时开跑。做法是初始化一个共享的CountDownLatch(1)，
 * 将其计数器初始化为1，多个线程在开始执行任务前首先 coundownlatch.await()，
 * 当主线程调用 countDown() 时，计数器变为0，多个线程同时被唤醒。
 **/
public class parallelTest {
    static  CountDownLatch Mainlatch=new CountDownLatch(1);
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();//初始化一个线程池
        for (int i = 0; i <300 ; i++) {
            es.execute(new inner());
        }
        System.out.println("主线程休息10s后，子线程同时执行");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Mainlatch.countDown();
        es.shutdown();
    }

     /**
       @Author:nieyc
       @Description: 一个静态内部类
       @Date:18:23 2018/7/3
      **/
    public static class inner implements  Runnable{
        public  inner(){
        }

        public static void   saySomeThing(){
            System.out.println("我是一个子线程，我的名字是："+Thread.currentThread().getName());
        }
        @Override
        public void run() {
            try {
                Mainlatch.await();
                saySomeThing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
