package thread.demo.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 22:25 2018/1/20
 * @Description 正確的計數器，採用lock機制
 **/
public class CounterLock {
    private  int counter =0;
    Lock lock = new ReentrantLock();

    public  void add(){
        lock.lock();
        try{
            counter++;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
       final CounterLock test=new CounterLock();
        Thread[] threads=new Thread[10];
        for (int i = 0; i <10 ; i++) {
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <10000 ; j++) {
                        test.add();
                    }

                }
            });
            threads[i]=t;
            t.start();
        }

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
