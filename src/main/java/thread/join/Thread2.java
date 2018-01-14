package thread.join;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description：统计程序执行时间.join();主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
         但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法
 **/
public class Thread2 implements  Runnable {
    private  String threadName;
    private  Thread2(String name){
        this.threadName=name;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("子线程"+threadName + "运行 : " + i);
        }
    }

    /**
     @Author:nieyc
     @Description: 主线程等待子线程执行完成后，继续执行收尾工作
     @Date:17:44 2018/1/12
     **/
    public static void main(String[] args) {
        System.out.println("主线程开始执行");
        Thread2 t1=new Thread2("A");
        Thread2 t2=new Thread2("B");
        Thread ta=new Thread(t1);
        Thread tb=new Thread(t2);
        ta.start();
        tb.start();
        try {
            ta.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            tb.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束");
    }
}
