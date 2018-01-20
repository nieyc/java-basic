package thread.demo.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description 卖票方案解决1：ReentrantLock 锁，方案1见
 * @see TicketSellSync
 **/
public class TicketSellLock  implements  Runnable {

    public   int ticketNum=50;
    Lock l=new ReentrantLock();


    @Override
    public void run() {
        for(int i = 0 ; i < 50 ;i ++){
            l.lock();
            if(ticketNum>0){
                try {
                    Thread.sleep(30);//模拟卖票需要一定的时间
                    System.out.println("窗口"+Thread.currentThread().getName()+ "卖出一张票，剩余 "+  (--ticketNum)+"张");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    l.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {
        TicketSellLock t=new TicketSellLock();
        Thread ta=new Thread(t,"A");
        Thread tb=new Thread(t,"B");
        Thread tc=new Thread(t,"C");
        ta.start();
        tb.start();
        tc.start();

    }
}
