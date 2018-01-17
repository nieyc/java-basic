package thread.pool.userDefined;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义一个线程池，用于理解线程池的原理。具体参数参考jdk说明
 * @author nyc
 * @version 0.1 (2018年1月17日 上午10:58:53)
 * @since 0.1
 * @see
 */
public class MyThreadPoolTest {
	private static int produceTaskSleepTime = 2;  
    private static int produceTaskMaxNumber = 10;  
  
    public static void main(String[] args) {  
        // 构造一个线程池  
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
        		TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2),
        		Executors.defaultThreadFactory(),
        		new ThreadPoolExecutor.DiscardOldestPolicy());  
  
        for (int i = 1; i <= produceTaskMaxNumber; i++) {  
            try {  
                // 产生一个任务，并将其加入到线程池  
                String task = "task@ " + i;  
                System.out.println("put " + task);  
                threadPool.execute(new ThreadPoolTask(task));  
                // 便于观察，等待一段时间  
                Thread.sleep(produceTaskSleepTime);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }
        } 
    }  
}
