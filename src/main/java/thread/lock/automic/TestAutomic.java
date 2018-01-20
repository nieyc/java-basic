package thread.lock.automic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 12:21 2018/1/19
 * @Description
 **/
public class TestAutomic {

    //定义线程数量
    private static int THREAD_NUM=10;

    /**
     @Author:nieyc
     @Description:
     @Date:11:20 2018/1/19
     **/
    static  class MutexBusiness{
        public  int sum=0;
        AtomicInteger mutex = new AtomicInteger(0);
        public  void  doSomeThing(){
            //CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，
            // 将内存值V修改为B，否则什么都不做
            if (mutex.compareAndSet(0, 1)==false){
               // System.out.println("期望值0和内存值不同，返回false");
                return;
            }
            if(sum<30000){
                try {
                    // 这里sleep一下，增加线程切换的概率。
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum+=50;
            }
            mutex.set(0);
        }

    }

    /**
     @Author:nieyc
     @Description:开启10个线程，执行doSomeThing（），执行业务逻辑，理论上应该是30000，实际结果=30000,此处说明通过cas解决并发问题
     @Date:11:28 2018/1/19
     **/
    public static void main(String[] args) {
        Long startTime=System.currentTimeMillis();
        //创建一个固定大小的线程数组
        Thread[] threads=new Thread[THREAD_NUM];
        final TestAutomic.MutexBusiness mutexBusiness=new MutexBusiness();
        //创建10个线程，并且启动
        for (int i = 0; i <THREAD_NUM ; i++) {
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10000;j++){
                        mutexBusiness.doSomeThing();

                    }
                }
            });
            t.start();
            threads[i]=t;
        }
        //主线程执行完后，在输出最终计算结果
        for (Thread t:threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sum:"+ mutexBusiness.sum);
        Long endTime=System.currentTimeMillis();
        System.out.println("total time is:"+(endTime-startTime));
    }

}
