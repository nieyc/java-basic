package thread.cancel;

import java.util.concurrent.*;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:48 2019/8/9
 * @Description
 **/
public class FutureTaskTest {

    public class Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            while (true) {
                System.out.println("我在执行任务: Test 来自"+Thread.currentThread().getName()+"\n");
                Thread.sleep(100);
            }
        }
    }

    public  void start(){
        ExecutorService exec= Executors.newCachedThreadPool();
        Future<String> future = exec.submit(new Task());
        try {
            future.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw launderThrowable(e.getCause());
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            System.out.printf("执行取消任务 \n");
            future.cancel(true);//如果任务正在运行，那么将被中断
        }
        System.out.printf("Canceled: "+ future.isCancelled()+"\n");
        System.out.printf("Done: "+ future.isDone()+"\n");
        exec.shutdown();
        System.out.printf("The executor has finished\n");
    }


     public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        }else if (t instanceof Error){
            throw (Error) t;
        } else{
            throw new IllegalStateException("Not unchecked", t);
        }
     }

    public static void main(String[] args) {
         new FutureTaskTest().start();
    }
}
