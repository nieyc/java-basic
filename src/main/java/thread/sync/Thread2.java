package thread.sync;

/**
 @Author:nieyc
 @Description:
   1:  当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，
 一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后
 才能执行该代码块。
   2: 测试用例：当两个线程ta，tb 分别执行50万次，count值理论上应该是100万次，实际测下来，如果不加同步，count<100万，加同步 count=100万
      原因：count++ 做了三个动作
            1：从内存取值放到寄存器
            2：寄存器对值执行+1操作
            3：值写入内存
       假设count=1，A线程走到步骤2，B线程走到步骤1，A 线程将count+1，count值为2写入内存，而此时B线程
       取到的值还是1，B线程也紧接着做加1的操作，将值写入内存，这样程序执行了2次，而count的值只加了1次
       官方术语：竞态条件与临界区
   3:volatile 关键字的使用
 @Date:11:22 2018/1/12
 **/
public class Thread2 implements  Runnable {

    private  static  int count=0;
   // private  static volatile int count=0;

    @Override
    public void run() {
        // synchronized (this){
             for(int i=0;i<500000;i++){
                 System.out.println(Thread.currentThread().getName()+"线程 "+i);
                 count++;
                 System.out.println("count :"+count);
             }
      //  }
    }



    public static void main(String[] args) {
        Long startTime=System.currentTimeMillis();
        System.out.println("主线程开始执行："+startTime);
        Thread2 t2=new Thread2();
        Thread ta=new Thread(t2,"A");
        ta.start();
        Thread tb=new Thread(t2,"B");
        tb.start();
        Long endTime=System.currentTimeMillis();
        System.out.println("主线程结束执行："+endTime);
        System.out.println("执行时间："+(endTime-startTime));

    }

}
