package dataStructure.queue.demo;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:33 2018/3/12
 * @Description
 **/
public class ProduceApple implements  Runnable  {

    private volatile boolean      isRunning               = true;

    ArrayBlockingQueue<Apple> queue=null;

    public ProduceApple(ArrayBlockingQueue<Apple> queue){
        this.queue=queue;
    }



    public void put(Apple apple){
        if (queue.size()==10){
            System.out.println("篮子里已经存满苹果，等待消费者消费");
        }
        try {
            queue.put(apple);
            System.out.println("生产苹果名称："+apple.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRunning){
            for (int i=0;i<100;i++){
                Random random=new Random();
                try {
                    Thread.sleep( random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                put(new Apple(i,"APPLE"+i));
                if(i==99){
                    stop();
                }

            }
        }

    }

    public void stop() {
        isRunning = false;
        System.out.println("生产者生产完毕，退出程序");
    }


}
