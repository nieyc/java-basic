package thread.future.futureTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:36 2018/1/17
 * @Description FutureTask 和Future 区别到底是什么，还需要理解，目前看来两者实现功能类似
 **/
public class FutureTaskTest {

    public  static void testFutureTask(){
        FutureTask task=new FutureTask(new MyTask(("A")));
        task.run();
        try {
            Integer result= (Integer) task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(task.isDone());
    }



    public static void main(String[] args) {
      // testFutureTask();
        testFutureTaskWithPool();
    }


    /**
     @Author:nieyc
     @Description:多线程的方式提交计算任务，主线程继续执行其他任务，当主线程需要子线程的计算结果时，
                    在异步获取子线程的执行结果。
     @Date:15:45 2018/1/17
     **/
    public static void testFutureTaskWithPool(){
        // 创建线程池
        ExecutorService exec=Executors.newCachedThreadPool();

        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();

        for (int i = 0; i <10 ; i++) {
            FutureTask<Integer> futureTask=new FutureTask<Integer>(new MyTask(String.valueOf(i)));
            taskList.add(futureTask);
            exec.submit(futureTask);
            System.out.println("提交task"+i+"任务成功");
        }
        System.out.println("所有计算任务提交完毕, 主线程接着干其他事情！");
        doSomeThing();
        Integer totalResult = 0;
        for (int i = 0; i <taskList.size() ; i++) {
            try {
                int result=taskList.get(i).get();
                System.out.println("result:"+result);
                totalResult=totalResult+result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        // 关闭线程池
        exec.shutdown();
        System.out.println("多任务计算后的总结果是:" + totalResult);
    }

    public static void doSomeThing(){
        try {
            System.out.println("模拟主线程做其他事情！主线程休息10秒开始");
            Thread.sleep(10000);
            System.out.println("模拟主线程做其他事情！主线程休息10秒结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
