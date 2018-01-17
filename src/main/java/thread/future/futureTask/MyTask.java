package thread.future.futureTask;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:36 2018/1/17
 * @Description
 **/
public class MyTask implements Callable<Integer> {
    private  String taskName;
    public  MyTask(String name){
        this.taskName=name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("task"+ taskName + "开始进行计算");
        Thread.sleep(5000);
        int result=0;
        int sum = new Random().nextInt(100);
        for (int i = 0; i <sum ; i++) {
            result=result+i;
        }
        System.out.println("任务"+taskName+"result:"+result);
        return result;
    }
}
