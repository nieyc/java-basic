package thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:13 2019/8/12
 * @Description:当 JVM 中不存在任何一个正在运行的非守护线程时，则 JVM 进程即会退出。
 * 如果屏蔽 t1.setDaemon(true);即使主线程main结束，因为t1线程是普通线程，一直在后台运行，所以jvm不会退出
 * 放开屏蔽，则程序会正常退出
 * 守护线程使用场景：
 * 典型例子就是java中的垃圾回收线程  jvm退出时候，垃圾回收线程自动关闭
 * 守护线程主要用于执行后台服务，并且希望程序退出时，或jvm退出时，线程能自动关闭
 **/
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        //添加一个钩子（Hook）线程, 用来监听 JVM 退出，并输出日志；
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("The JVM exit success !!!")));
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 睡眠一秒
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("I am running ...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 将该线程设置为守护线程
        t1.setDaemon(true);
        // 启动线程
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        // 主线程即将退出
        System.out.println("The main thread ready to exit..");

    }
}
