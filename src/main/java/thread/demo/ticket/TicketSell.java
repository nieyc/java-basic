package thread.demo.ticket;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class TicketSell extends Thread {
    //定义一共有 50 张票，注意声明为 static,表示几个窗口共享
    public  static int ticketNum=50;
    //调用父类构造方法，给线程命名
    public TicketSell(String Name){
        super(Name);
    }
    @Override
    public void run(){
        while(ticketNum>0){
            try {
                Thread.sleep(10);//模拟卖票需要一定的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口"+Thread.currentThread().getName()+ "卖出一张票，剩余 "+--ticketNum);
        }
    }


    public static void main(String[] args) {
        TicketSell ta=new TicketSell("A");
        TicketSell tb=new TicketSell("B");
        TicketSell tc=new TicketSell("C");
        ta.start();
        tb.start();
        tc.start();
    }

}
