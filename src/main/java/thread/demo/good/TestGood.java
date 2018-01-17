package thread.demo.good;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:40 2018/1/16
 * @Description :实现了一个生产者，消费者模式，future.get() 方法执行时候，返回结果后，后面的代码才会执行
 *                官方语言描述：如果线程没有返回结果，就阻塞当前线程等待线程池结果返回
 *  @see thread.demo.produce.TestProduct
 **/
public class TestGood {

    public static void main(String[] args) {
        ExecutorService execService= Executors.newCachedThreadPool();
        for (int i = 1; i <=10 ; i++) {
            Good good=new Good(i,"商品"+i);
            Future<String> future_p= execService.submit(new ProduceGood(good));
            try {
                future_p.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            Future<String> future_c= execService.submit(new ConsumerGood(good));
            try {
               future_c.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        execService.shutdown();
    }
}
