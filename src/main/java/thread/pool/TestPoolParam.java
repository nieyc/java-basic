package thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:30 2019/8/13
 * @Description:线程池各种参数的配置
 * corePoolSize：核心池大小，线程池最大并发量,一般是机器核数+1，比如8核，那么就是9
 * maximumPoolSize:线程池维护线程的最大数量，需要综合考虑，任务类型，cpu计算密集还是IO密集，内存大小
 * keepAliveTime:线程池维护线程所允许的空闲时间
 * unit:线程池维护线程所允许的空闲时间单位
 * workQueue：线程池所使用的缓冲队列
 * handler:线程池对拒绝任务的处理策略
 * 任务处理顺序：核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
 *
 * 示例:corePoolSIze=2，maximumPoolSize=5，LinkedBlockingQueue.size=2, 1000个任务提交到线程池，分别用4种拒绝策略
 * 1：CallerRunsPolicy，1000个任务可以执行完毕，当线程池满了，根据输出发现main线程也可以执行任务，如“线程：main 生产订单Id：order-7名称：name-7”
 * 2：AbortPolicy:抛出异常java.util.concurrent.RejectedExecutionException，并且只有7个任务得到了处理，应该是workQueue+maximumPoolSize=7，线程并不退出，这个是默认的策略。
 * 3：DiscardPolicy:1000个任务也是只执行了7个，其他全部丢弃，但是没有抛出异常，程序正常结束
 * 4:DiscardOldestPolicy: 这个比较特殊，也是1000个任务执行了7个，前面5个，后面2个，完整日志如下（丢弃队列最前面的任务）
 * 任务提交完毕。。。。。。。。。。。。。
线程：pool-1-thread-3 生产订单Id：order-4名称：name-4
线程：pool-1-thread-5 生产订单Id：order-6名称：name-6
线程：pool-1-thread-4 生产订单Id：order-5名称：name-5
线程：pool-1-thread-1 生产订单Id：order-0名称：name-0
线程：pool-1-thread-2 生产订单Id：order-1名称：name-1
线程：pool-1-thread-3 生产订单Id：order-998名称：name-998
线程：pool-1-thread-4 生产订单Id：order-999名称：name-999
Process finished with exit code 0

 **/
public class TestPoolParam {

    ThreadFactory csswebThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

    ThreadPoolExecutor executor=new ThreadPoolExecutor(2,
            5,
            10,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(2),
            // new ThreadPoolExecutor.CallerRunsPolicy()//由调用线程处理该任务,当有任务添加到线程池被拒绝时，线程池会将被拒绝的任务添加到”线程池正在运行的线程”中取运行。
            // new ThreadPoolExecutor.AbortPolicy()//丢弃任务并抛出RejectedExecutionException异常。
            //new ThreadPoolExecutor.DiscardPolicy()//也是丢弃任务，但是不抛出异常
            csswebThreadFactory,//给线程起个名字，方便日志调试，默认是Executors.defaultThreadFactory()
            new ThreadPoolExecutor.DiscardOldestPolicy()//丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）

    );


    public class  Order{
        private String orderId;
        private String orderName;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }

    }

    public class createOrder implements Runnable{
        public Order order;

        public createOrder(Order order){
            this.order=order;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                System.out.println("线程："+Thread.currentThread().getName()+" 生产订单Id："+order.getOrderId()+"名称："+order.getOrderName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //out_pirint();
        }
    }

    public void start(){
        for (int i = 0; i <1000 ; i++) {
            System.out.println("i:"+i);
            Order order=new Order();
            order.setOrderId("order-"+i);
            order.setOrderName("name-"+i);

            executor.submit(new createOrder(order));
        }
        System.out.println("任务提交完毕。。。。。。。。。。。。。");
        executor.shutdown();
    }

    public void out_pirint(){
        System.out.println("start----------------------------------------------------");
        System.out.println("executor.getActiveCount():"+executor.getActiveCount());
        System.out.println("executor.getCorePoolSize():"+executor.getCorePoolSize());
        System.out.println("executor.getLargestPoolSize():"+executor.getLargestPoolSize());
        System.out.println("executor.getQueue().size:"+executor.getQueue().size());
        // System.out.println("executor.getRejectedExecutionHandler():"+executor.getRejectedExecutionHandler());
        System.out.println("executor.getCompletedTaskCount():"+executor.getCompletedTaskCount());
        System.out.println("executor.getMaximumPoolSize():"+executor.getMaximumPoolSize());
        System.out.println("end----------------------------------------------------");
    }

    public static void main(String[] args) {
        new TestPoolParam().start();
    }
}
