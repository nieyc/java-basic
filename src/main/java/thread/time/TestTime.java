package thread.time;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 11:09 2018/3/14
 * @Description 一个简单的定时器，一秒执行一次
 **/
public class TestTime {

  static class Task extends TimerTask{
        @Override
        public void run() {
            System.out.println("Do work...");
        }
    }
    public static void main(String[] args) {
        Timer time=new Timer();
        Task task=new Task();
        time.schedule(task,new Date(),1000);
    }
}
