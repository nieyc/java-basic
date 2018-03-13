package dataStructure.queue.delyed;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:37 2018/3/12
 * @Description
 **/
public class MyTask implements Delayed {

    public String  taskName;//任务名称

    public long executeTime;//任务到期执行时间(纳秒)

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     @Author:nieyc
     @Description:
     @Date:14:41 2018/3/12
     @param delayTime: 延时时间，毫秒表示。
     **/
    public MyTask(String taskName,long delayTime){
        this.taskName=taskName;
        //任务到期执行时间，纳秒表示
        this.executeTime=TimeUnit.NANOSECONDS.convert(delayTime,TimeUnit.MILLISECONDS)+System.nanoTime();
    }

    /**
     @Author:nieyc
     @Description:获取剩余时间，单位纳秒
     @Date:14:48 2018/3/12
     **/
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
       MyTask task=(MyTask)other;
      /* long diff=executeTime-task.executeTime;
       if(diff<0){
           return -1;
       }else if(diff>0){
           return 1;
       }else {
           return 0;
       }*/
       long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
       return (d == 0) ? 0 : ((d < 0) ? -1 : 1);

    }

    public static void main(String[] args) {
        long delayTime=1000l;//1秒
        long nanoTime=System.nanoTime();//系统当前时间，纳秒表示
        System.out.println(nanoTime);
        long currentTime=System.currentTimeMillis();//系统当前时间，毫秒表示
        System.out.println(currentTime);
        long executeTime=TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) ;//把1000毫秒转为纳秒（1000000000）,10亿纳秒
        System.out.println(executeTime);
        long t=executeTime+ nanoTime;//最终时间以纳秒来表示
        System.out.println(t);
    }
}
