package thread.semaphore;

import java.util.concurrent.*;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:40 2019/8/14
 * @Description: 信号量，控制线程并发数，常用于限制可以访问某些资源（物理或逻辑的）线程数目
 * 事例说明：10个任务提交到一个无界队列线程池，最大并发只有3个
 * @see thread.pool.TestPoolParam 和手动创建线程池对比，最大并发量就是线程池最大值,也可以实现同样的功能，限制并发
 **/
public class BoundedExecutor {
    private final Executor exec;
    private final Semaphore semaphore;
    int bound;

    public BoundedExecutor( Executor exec,int bound){
        this.exec=exec;
        this.bound=bound;
        this.semaphore=new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException{
        //通过 acquire() 获取一个许可
        semaphore.acquire();
        System.out.println("----------当前可用的信号量个数:"+semaphore.availablePermits());
        try{
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() +"进入，当前已有" + (bound-semaphore.availablePermits()) + "个并发");
                        command.run();
                    } finally {
                    //release() 释放一个许可
                      semaphore.release();
                      System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有" + (bound-semaphore.availablePermits()) + "个并发");
                    }
                }
             });
        } catch (RejectedExecutionException e) {
                    semaphore.release();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        BoundedExecutor e = new BoundedExecutor(exec, 3);
        for (int i = 0; i <10 ; i++) {
              final int c = i;
              e.submitTask(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          Thread.sleep(5000);
                      } catch (InterruptedException e1) {
                          e1.printStackTrace();
                      }
                      System.out.println("执行任务:" +c);
                  }
              });
        }
        exec.shutdown();
    }

}
