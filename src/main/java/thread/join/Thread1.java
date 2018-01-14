package thread.join;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class Thread1 implements  Runnable {
    private  String threadName;
    private  Thread1(String name){
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
     @Description: 主线程先于子线程结束
     @Date:17:41 2018/1/12
     **/
    public static void main(String[] args) {
        System.out.println("主线程开始执行");
        Thread1 t1=new Thread1("A");
        Thread1 t2=new Thread1("B");
        Thread ta=new Thread(t1);
        Thread tb=new Thread(t2);
        ta.start();
        tb.start();
        System.out.println("主线程执行结束");
    }
}
