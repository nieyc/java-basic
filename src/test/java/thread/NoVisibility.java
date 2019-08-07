package thread;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:26 2019/8/1
 * @Description
 **/
public class NoVisibility {
    private static boolean ready;
    private static  int number;

    private  static  class ReaderThread extends Thread{
        public  void run(){
           // System.out.println("ready:"+ready);
            while (!ready){
                Thread.yield();
                System.out.println("number:"+number);
            }
        }
    }

    public static void main(String[] args) {
            new ReaderThread().start();
            number=42;
            ready=true;
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);


    }
}
