package thread.demo.ticket;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class TicketSellRunnable implements  Runnable {
    public   int ticketNum=50;

    @Override
    public void run() {
        for(int i = 0 ; i < 50 ;i ++){
           // synchronized (this){
                if(ticketNum>0){
                    try {
                        Thread.sleep(10);//模拟卖票需要一定的时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("窗口"+Thread.currentThread().getName()+ "卖出一张票，剩余 "+  (--ticketNum)+"张");

                }
            //}


        }
    }

    /**
     @Author:nieyc
     @Description:这里出现了票数为 负数的情况，这在现实生活中肯定是不存在的，那么为什么会出现这样的情况呢？
     仔细查看控制台输出，发现有两个窗口卖了同一张票，为毛会出现这个情况呢？
     1：A，B两个线程同时进入if(ticketNum>0)代码块中，A已经执行到输出语句，但还没有执行--ticketNum，此时B也开始执行打印操作，两个窗口
        卖同一张票了
     2：当A执行打印语句了，并且完成--ticketNum,此时ticketNum=0;B在执行打印和--ticketNum,就出现负的票数了
     @Date:19:32 2018/1/14
     **/
    public static void main(String[] args) {
        TicketSellRunnable t=new TicketSellRunnable();
        Thread ta=new Thread(t,"A");
        Thread tb=new Thread(t,"B");
        Thread tc=new Thread(t,"C");
        ta.start();
        tb.start();
        tc.start();
    }
}
