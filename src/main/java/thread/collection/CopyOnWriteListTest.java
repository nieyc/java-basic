package thread.collection;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:45 2019/8/5
 * @Description:同一时刻不能对一个List（ArrayList） 对象内容进行读取和写入，否则会报错，ArrayList 不是线程安全的，换为
 * CopyOnWriteArrayList ，可以同时多线程读写
 * 优点：CopyOnWriteArrayList可以解决多线程并发读写
 * 缺点：内存占用大，如果集合中数据较多，而且比较大的情况下，会占用2倍原来的内存，原理是CopyOnWriteArrayList写入时，先复制一个副本
 *
 **/
public class CopyOnWriteListTest {
    //private List<String> list=new ArrayList<String>();
    private List<String> list=new CopyOnWriteArrayList<String>();

    private  static final  int THREAD_POOL_MAX_NUM=10;

    private void initData() {
        for(int i = 0 ; i <= THREAD_POOL_MAX_NUM ; i ++){
            this.list.add("...... Line "+(i+1)+" ......");
        }
    }
    private  void start(){
        initData();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 100, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(200), new ThreadPoolExecutor.DiscardOldestPolicy());
        System.out.println("list.size():"+list.size());
        for (int i = 0; i <100 ; i++) {
            executor.execute(new ReadList(list));
            executor.execute(new WriteList(list,i));
        }
        executor.shutdown();
    }

    private  class ReadList implements Runnable{
        private  List<String> readList;
        public ReadList(List list){
            this.readList=list;
        }
        @Override
        public void run() {
            if(this.readList!=null){
                for(String str:readList){
                    System.out.println(Thread.currentThread().getName()+":"+str);
                }
            }
        }
    }


    private  class WriteList implements Runnable{
        private  List<String> writeList;
        private  int index;
        public WriteList(List list,int index){
            this.writeList=list;
            this.index=index;
        }
        @Override
        public void run() {
            if(this.writeList!=null){
                writeList.add("...... add "+index +" ......");
            }
        }
    }
    public static void main(String[] args) {
        new CopyOnWriteListTest().start();
    }

}
