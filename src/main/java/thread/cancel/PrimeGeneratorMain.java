package thread.cancel;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:48 2019/8/9
 * @Description
 **/
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 11:19 2019/8/8
 * @Description:使用volatile 类型的域来保存取消状态
 * @see InterruptTest
 **/
public class PrimeGeneratorMain {

    /**
     @Author:nieyc
     @Description:找大于1的素数，100毫秒之后自动停止线程
     @Date:14:18 2019/8/8
     **/
    public class PrimeGenerator implements Runnable{


        private final List<BigInteger> primeList = new ArrayList<BigInteger>();

        private volatile boolean cancelled;

        @Override
        public void run() {
            BigInteger p = BigInteger.ONE;
            while(!cancelled){
                p = p.nextProbablePrime();
                synchronized (this) {
                    primeList.add(p);
                }
            }
        }

        public void cancel(){
            cancelled = true;
        }

        public synchronized List<BigInteger> get(){
            return new ArrayList<BigInteger>(primeList);
        }
    }

    public  void start(){
        System.out.println("start");
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            generator.cancel();
        }
        List<BigInteger> ls = generator.get();
        for(int i= 0;i<ls.size();i++){
            System.out.println(ls.get(i));
        }
    }
    public static void main(String[] args) {
        new PrimeGeneratorMain().start();
    }
}

