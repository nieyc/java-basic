package dataStructure.queue.priority;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 22:17 2018/3/10
 * @Description:优先级队列和普通队列的比较
 **/
public class PriorityTask implements  Runnable,Comparable {
    private  int priority;//优先级

    public PriorityTask(int priority){
        this.priority=priority;
    }
    @Override
    public int compareTo(Object o) {
        PriorityTask task=(PriorityTask)o;
        if(this.priority==task.priority){
            return 0;
        }
        return this.priority>task.priority?1:-1;
    }

    @Override
    public void run() {
        System.out.println("开始执行优先级："+priority+"的任务");
    }


    public static void blockingQueue(final BlockingQueue<PriorityTask> queue){
        Random random=new Random();
        for (int i = 0; i <10 ; i++) {
             int priority=random.nextInt(1000);
             System.out.println("元素优先级："+priority);
            try {
                queue.put(new PriorityTask(priority));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                while( !Thread.currentThread().isInterrupted() ){
                    try {
                        //取出队列中元素
                        queue.take().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("******开始测试普通阻塞队列******");
        blockingQueue(new LinkedBlockingQueue<PriorityTask>());
        Thread.sleep(10000);
        System.out.println("******开始测试优先级队列******");
        blockingQueue(new PriorityBlockingQueue<PriorityTask>());
    }
}
