package thread.demo.counter;



/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:36 2018/1/20
 * @Description 錯誤的計數器，自增是非線程安全的
 * volatile 的用法：此處並不能保證計算器結果，因為自增操作不是原子性操作，而且volatile也无法保证对变量的任何操作都是原子性的
    *     为什么不是原子性：1：读取变量的原始值，2：进行加1操作，3：写入内存。当多个线程并行执行时候，3个操作可能是分隔执行
 * @see：http://www.cnblogs.com/dolphin0520/p/3920373.html
 **/
public class CounterTest {
    private static int counter=0;

    private volatile  int count=0;

    public  void add(){
        for (int i = 0; i <10000 ; i++) {
            counter++;
            count++;
        }
    }

    public static void main(String[] args) {
      final  CounterTest test=new CounterTest();
        for (int i = 0; i <10 ; i++) {
            new Thread(){
                public  void run(){
                    test.add();
                }
            }.start();
        }


        while (Thread.activeCount()>2){
            System.out.println("Thread.activeCount():"+Thread.activeCount());
        }
            Thread.yield();
            System.out.println("counter:"+test.counter);
            System.out.println("count:"+test.count);
    }



}
