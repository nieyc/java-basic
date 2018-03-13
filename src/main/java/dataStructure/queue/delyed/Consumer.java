package dataStructure.queue.delyed;

import java.util.concurrent.DelayQueue;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:50 2018/3/12
 * @Description
 **/
public class Consumer implements Runnable {

    private DelayQueue<MyTask> queue;

    public  Consumer(DelayQueue<MyTask> queue){
      this.queue=queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                MyTask task=queue.take();
                System.out.println("taskName:"+task.getTaskName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
