package thread.countDown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:00 2018/7/3
 * @Description:官方学名叫闭锁 demo：10个不同的任务都完成了，在执行主线程的动作（输出一句话）
 **/
public class Test {

    public static void completeTask(){
        System.out.println("10 个任务都完成了");
    }
     /**
       @Author:nieyc
       @Description: 模拟10个不同的线程
       @Date:17:31 2018/7/3
      **/
    public static void main(String[] args) {
        CountDownLatch subThread=new CountDownLatch(10);
        for (int i = 0; i <10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Random r=new Random();
                        int hh=r.nextInt(10);
                        System.out.println("任务名称:"+Thread.currentThread().getName()+"准备休息"+hh+"秒");
                        Thread.sleep(hh*1000);
                        System.out.println("任务名称:"+Thread.currentThread().getName()+"休息"+hh+"秒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println("线程"+Thread.currentThread().getName()+"完成");
                        subThread.countDown();
                    }
                }
            }).start();
        }
        try {
            subThread.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        completeTask();

    }

}
