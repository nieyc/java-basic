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

        Timer time=new Timer();
       // TimerCircleTask timerTask=new TimerCircleTask();
        TimeTask timerTask=new TimeTask();
        time.schedule(timerTask,new Date(),1000);


        Random random=new Random();
        for(int i=1;i<=10;i++){
            long d=random.nextInt(60);
            int n=random.nextInt(2);
            Task task=new Task("A"+i,n,d);
            Task.circleQueue.put(task);
            System.out.println("放入集合数据"+"A"+i+"  延迟时间:"+d+"  cicle:"+n);
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==10){
                System.out.println("****************************************************put 任务完成***********************************************************");
            }
        }




    }
}
