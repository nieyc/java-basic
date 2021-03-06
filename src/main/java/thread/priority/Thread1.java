package thread.priority;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class Thread1 implements  Runnable {
    private  String threadName;

    private Thread1(String name){
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
     @Description: 优先级的设定，谁先执行
                   优先级低只是意味着获得调度的概率低。并不是绝对先调用优先级高的线程后调用优先级低的线程。具体各个操作系统也不同
     @Date:18:16 2018/1/12
     **/
    public static void main(String[] args) {
        Thread1 t1=new Thread1("A");
        Thread1 t2=new Thread1("B");
        Thread ta=new Thread(t1);
        Thread tb=new Thread(t2);
        tb.setPriority(Thread.MAX_PRIORITY);
        ta.setPriority(Thread.MIN_PRIORITY);
        tb.start();
        ta.start();
        new Thread(new Thread1("C")).start();
        new Thread(new Thread1("D")).start();
        //默认线程优先级是5
        System.out.println(Thread.currentThread().getPriority());  

    }
}
