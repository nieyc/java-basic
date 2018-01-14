package thread.yield;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class Thread1 extends   Thread {
    private  String threadName;

    private Thread1(String name){
        this.threadName=name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("" + this.threadName + "-----" + i);
            // 当i为3时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
          if (i==3){
              this.yield();
              System.out.println("==========================================");
          }
        }
    }

    public static void main(String[] args) {
        Thread1 t1=new Thread1("A");
        Thread1 t2=new Thread1("B");
        Thread ta=new Thread(t1);
        Thread tb=new Thread(t2);
        ta.start();
        tb.start();

    }
}
