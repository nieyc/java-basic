package thread.demo.ticket;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description 卖票方案解决1：使用synchronized 同步锁，注意不能用在run()方法上，否则只执行1个线程，其他的没有机会，方案2见 @see TicketSellLock
 **/
public class TicketSellSync implements  Runnable  {
    public   int ticketNum=50;
    @Override
    public  void run() {
        for(int i = 0 ; i < 50 ;i ++){
            sell();
        }
    }

    private synchronized void sell(){
        if(ticketNum > 0){
            try {
                //模拟卖一次票所需时间
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+(--ticketNum)+"张");
        }
    }


    public static void main(String[] args) {
        TicketSellSync t=new TicketSellSync();
        Thread ta=new Thread(t,"A");
        Thread tb=new Thread(t,"B");
        Thread tc=new Thread(t,"C");
        ta.start();
        tb.start();
        tc.start();
    }
}
