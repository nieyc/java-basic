package dataStructure.queue.demo;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:34 2018/3/12
 * @Description
 **/
public class ConsumerApple implements  Runnable{
    private volatile boolean      isRunning               = true;

    ArrayBlockingQueue<Apple> queue=null;

    public ConsumerApple(ArrayBlockingQueue<Apple> queue){
        this.queue=queue;
    }

    public void getApple(ArrayBlockingQueue<Apple> queue){

        try {
          //Apple apple=  queue.take();
            Apple apple=queue.poll(10, TimeUnit.SECONDS);
          if(apple==null){
              System.out.println("篮子里已经10秒没有苹果，退出程序");
              isRunning=false;
          }else {
              System.out.println("消费苹果名称："+apple.getName()+"篮子剩余苹果数量:"+queue.size());
          }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
         while (isRunning){
             Random random=new Random();
             try {
                 Thread.sleep( random.nextInt(1000));
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             getApple(queue);
         }
    }
}
