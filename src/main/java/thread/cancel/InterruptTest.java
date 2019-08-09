package thread.cancel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:55 2019/8/9
 * @Description:线程中断
 * @see thread.cancel.PrimeGeneratorMain
 **/
public class InterruptTest {
    /**
     @Author:nieyc
     @Description:找大于1的素数，100毫秒之后自动停止线程,线程中断
     @Date:14:18 2019/8/8
     **/
    public class PrimeGenerator implements Runnable{


        private final List<BigInteger> primeList = new ArrayList<BigInteger>();

        @Override
        public void run() {
            BigInteger p = BigInteger.ONE;
            while(!Thread.currentThread().isInterrupted()){
                p = p.nextProbablePrime();
                synchronized (this) {
                    primeList.add(p);
                }
            }
        }

        public synchronized List<BigInteger> get(){
            return new ArrayList<BigInteger>(primeList);
        }
    }

    public  void start(){
        System.out.println("start");
        PrimeGenerator generator = new PrimeGenerator();
        Thread genThread=new Thread(generator,"gen");
        genThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            genThread.interrupt();
        }
        List<BigInteger> ls = generator.get();
        for(int i= 0;i<ls.size();i++){
            System.out.println(ls.get(i));
        }
    }
    public static void main(String[] args) {
        new InterruptTest().start();
    }

}
