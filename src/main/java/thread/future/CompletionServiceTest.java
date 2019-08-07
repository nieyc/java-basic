package thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:01 2019/8/7
 * @Description :https://www.cnblogs.com/xingele0917/p/3974187.html
 *  场景：有5个Callable任务分别返回5个整数，然后我们在main方法中按照各个任务完成的先后顺序，在控制台打印返回结果
 **/
public class CompletionServiceTest {

    public static int taskSize = 5;

     /**
       @Author:nieyc
       @Description:
       @Date:14:07 2019/8/7
      **/
    private   class ReturnAfterSleepCallable implements Callable<Integer>{
        private int sleepSeconds;
        private int returnValue;

        public  ReturnAfterSleepCallable(int sleepSeconds,int returnValue ){
              this.returnValue=returnValue;
              this.sleepSeconds=sleepSeconds;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("begin to exectue");
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return returnValue;
        }
    }

     /**
       @Author:nieyc
       @Description: 传统的繁琐做法，把任务都提交给线程池，并且放到集合中，然后轮询集合
       @Date:14:32 2019/8/7
      **/
    public void TraditionalTest(){
         ExecutorService executor=Executors.newFixedThreadPool(taskSize);
         List<Future<Integer>> futureList=new CopyOnWriteArrayList<Future<Integer>>();
        for (int i = 0; i <taskSize ; i++) {
            int sleep = taskSize -1;
            int value=i;
            //向线程池提交任务
            Future future=  executor.submit(new ReturnAfterSleepCallable(sleep,value));
            //保留每个任务的future
            futureList.add(future);

        }
        while (taskSize>0){
            for (Future<Integer> f:futureList) {
                Integer result =null;
                try {
                    result = f.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if (result!=null){
                    System.out.println("result = "+result);
                    //从future列表中删除已经完成的任务
                    futureList.remove(f);
                    taskSize--;
                    //break;
                }
            }
        }
        // 所有任务已经完成,关闭线程池
        System.out.println("all over. ");
        executor.shutdown();
    }

     /**
       @Author:nieyc
       @Description:CompletionService实现了生产者提交任务和消费者获取结果的解耦，生产者和消费者都不用关心任务的完成顺序，
                     由CompletionService来保证，消费者一定是按照任务完成的先后顺序来获取执行结果。ExecutorCompletionService
                    源码，发现是由LinkedBlockingQueue实现，阻塞队列，阻塞和有序
       @Date:15:07 2019/8/7
      **/
     public void TestCompletion(){
         ExecutorService executor = Executors.newCachedThreadPool();
         CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
         for (int i = 0; i <taskSize ; i++) {
             int sleep=taskSize-i;
             int value=i;
             completionService.submit(new ReturnAfterSleepCallable(sleep,value));
             try {
               int returnValue= completionService.take().get();
                // int returnValue= completionService.take().get(1,TimeUnit.SECONDS);
                 System.out.println("returnValue:"+returnValue);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (ExecutionException e) {
                 e.printStackTrace();
             }
         }
         System.out.println("all over. ");
         executor.shutdown();

     }


    public static void main(String[] args) {
        //new CompletionServiceTest().TraditionalTest();
        new CompletionServiceTest().TestCompletion();

    }


}
