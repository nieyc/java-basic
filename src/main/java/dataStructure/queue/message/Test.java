package dataStructure.queue.message;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:38 2018/3/14
 * @Description
 **/
public class Test {
    public static void main(String[] args) {
        ExecutorService execService= Executors.newCachedThreadPool();
        CircleQueue circleQueue=new CircleQueue();
        Random random=new Random();
        for(int i=1;i<=100;i++){
            long d=random.nextInt(100);
            int n=random.nextInt(5);
            System.out.println("A"+i+"  延迟时间:"+d+"  cicle:"+n);
            Task task=new Task("A"+i,n,d);
            circleQueue.put(task);
        }
        //execService.execute(new Task(circleQueue));
        Timer time=new Timer();
        TimerCircleTask timerTask=new TimerCircleTask(circleQueue);
        time.schedule(timerTask,new Date(),1000);


    }
}
