package thread.cancel;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:39 2019/8/8
 * @Description:不可靠的取消，因为生产者或消费者会出现阻塞事件
 **/
public class BrokenPrimeProducerMain {

    public class BrokenPrimeProducer implements Runnable{

       private final BlockingQueue<BigInteger> queue;
       private volatile boolean cancelled;

       public BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
            this.queue=queue;
        }
        @Override
        public void run() {
            BigInteger p = BigInteger.ONE;
            while(!cancelled){
                try {
                    p= p.nextProbablePrime();
                    queue.put(p);
                    System.out.println(Thread.currentThread().getName()+"生产数字："+p);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+"线程中断");
                }
            }
        }

        public void cancel(){
            cancelled = true;
        }
    }

    public void start(){
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(3);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(queue);
        new Thread(producer).start();
        while (true){
            try {
                System.out.println(Thread.currentThread().getName()+"消费数据："+queue.take());//从队列取数据
                TimeUnit.SECONDS.sleep(1);//停止1s,显示出消费速度慢于生产速度
                producer.cancel();// 消费者请求停止生产
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("被中断了");
            }
        }
    }

    public static void main(String[] args) {
       new BrokenPrimeProducerMain().start();
    }
}
