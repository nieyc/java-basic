package thread.demo.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 22:37 2018/1/20
 * @Description 正確的計數器
 * @see thread.lock.automic.TestAutomic
 **/
public class CounterAtomatic {

    private AtomicInteger counter=new AtomicInteger(0);

    public  void add(){
        for (int i = 0; i <10000 ; i++) {
            counter.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        final   CounterAtomatic test=new CounterAtomatic();
        Thread[] threads=new Thread[10];
        for (int i = 0; i <10 ; i++) {
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    test.add();
                }
            });
            threads[i]=t;
            t.start();
        };
        for (Thread t:threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(test.counter);
    }

}
