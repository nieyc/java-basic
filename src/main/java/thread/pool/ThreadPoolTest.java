package thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:14 2019/1/23
 * @Description
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadFactory alibabaThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ExecutorService ex=new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), alibabaThreadFactory);


            ex.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<50000;j++) {
                        System.out.println("-----");
                    }

                }
            });

        ex.shutdown();
        while(!ex.isTerminated()){
            System.out.println("wait all gave over");
        }


    }
}
