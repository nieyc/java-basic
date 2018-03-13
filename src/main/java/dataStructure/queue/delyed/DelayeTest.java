package dataStructure.queue.delyed;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:47 2018/3/12
 * @Description
 **/
public class DelayeTest {
    public static void main(String[] args) {
        DelayQueue<MyTask> queue=new DelayQueue<MyTask>();
        MyTask task1=new MyTask("task1",8000);
        MyTask task2=new MyTask("task2",1000);
        MyTask task3=new MyTask("task3",5000);
        queue.offer(task1);
        queue.offer(task2);
        queue.offer(task3);

        ExecutorService exec= Executors.newFixedThreadPool(1);
        exec.execute(new Consumer(queue));
        //exec.shutdown();
     /*   for (int i = 0; i <3 ; i++) {
            try {
                MyTask task= queue.take();
                System.out.println("task:"+task.getTaskName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
