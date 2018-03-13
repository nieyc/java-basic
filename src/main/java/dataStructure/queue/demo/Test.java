package dataStructure.queue.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:50 2018/3/12
 * @Description:生产者和消费者一个例子，不同于线程部分，是通过队列实现。
 *                先生产后消费，生产的数据放在中间队列里，消费者从队列获取数据，如果队列满或者空，生产者和消费者需要等待
 *  @see thread.demo.good.TestGood
 *  @see thread.demo.produce.TestProduct
 **/
public class Test {
    public static void main(String[] args) {
        ArrayBlockingQueue<Apple> queue=new ArrayBlockingQueue<Apple>(10);
        ExecutorService execService= Executors.newCachedThreadPool();
        execService.execute(new ProduceApple(queue));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        execService.execute(new ConsumerApple(queue));
        execService.shutdown();
    }
}
