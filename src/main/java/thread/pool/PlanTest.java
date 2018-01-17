package thread.pool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:56 2018/1/15
 * @Description 适用于一些计划任务
 **/
public class PlanTest implements  Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1 * 1000);
            doSomeThing();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  void doSomeThing(){
        System.out.println(System.currentTimeMillis());
    }

    /**
     @Author:nieyc
     @Description:按指定频率周期执行某个任务
     初始化延迟0ms开始执行，每隔2000ms重新执行一次任务
     @Date:16:04 2018/1/15
     **/
    public static void executeFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleAtFixedRate(
                new PlanTest(),
                0,
                2000,
                TimeUnit.MILLISECONDS);
    }

    /**
     @Author:nieyc
     @Description:按指定频率间隔执行某个任务
     以固定延迟时间进行执行
     本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务
     @Date:16:07 2018/1/15
     **/
    public static void executeFixedDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleWithFixedDelay(
                new PlanTest(),
                0,
                2000,
                TimeUnit.MILLISECONDS);
    }


    /**
     @Author:nieyc
     @Description:每天晚上9点执行一次,每天定时安排任务进行执行
     @Date:16:13 2018/1/15
     **/
    public static void executeEightAtNightPerDay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis("21:00:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

        executor.scheduleAtFixedRate(
                new PlanTest(),
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 获取指定时间对应的毫秒数
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        //executeFixedRate();
        //executeFixedDelay();
        executeEightAtNightPerDay();
    }
}
