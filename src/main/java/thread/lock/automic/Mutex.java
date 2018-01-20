package thread.lock.automic;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:25 2018/1/19
 * @Description 互斥类，多线程并发测试，并且通过Automatic 解决并发问题，同时自己实现一个简单的自旋锁
 **/
public class Mutex {

    //定义线程数量
    private static int THREAD_NUM=10;

    /**
     @Author:nieyc
     @Description: 一个静态内部类，主要是为了Mutex类使用，没必要暴露出去
     @Date:11:20 2018/1/19
     **/
    static  class MutexBusiness{
        public   int sum=0;

        public  void  doSomeThing(){
            //System.out.println("thread："+Thread.currentThread().getName());
            if(sum<30000){
                try {
                    // 这里sleep一下，增加线程切换的概率
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum+=50;
            }
        }

    }

    /**
     @Author:nieyc
     @Description:开启10个线程，执行doSomeThing（），执行业务逻辑，理论上应该是30000，实际结果>30000,此处说明出现了并发问题
     @Date:11:28 2018/1/19
     **/
    public static void main(String[] args) {
         //创建一个固定大小的线程数组
         Thread[] threads=new Thread[THREAD_NUM];
         //初始化静态内部类
         final Mutex.MutexBusiness mutexBusiness=new MutexBusiness();
         //创建10个线程，并且启动
        for (int i = 0; i <THREAD_NUM ; i++) {
             Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                        for (int j=0;j<10000;j++){
                            mutexBusiness.doSomeThing();
                           // mutexBusiness.doSyncSomeThing();
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
        System.out.println("total:"+ mutexBusiness.sum);
    }

}
