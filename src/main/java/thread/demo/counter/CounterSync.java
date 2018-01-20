package thread.demo.counter;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 22:15 2018/1/20
 * @Description 正確的計數器，採用同步鎖機制
 * @see thread.lock.automic.TestAutomic
 **/
public class CounterSync {
    private  int counter =0;

    public synchronized void add(){
        for (int i = 0; i <10000 ; i++) {
            counter++;
        }
    }

    public static void main(String[] args) {
        final   CounterSync test=new CounterSync();
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
