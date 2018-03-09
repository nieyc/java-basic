package dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:33 2018/3/8
 * @Description
 **/
public class QueueTest {
    /**
     @Author:nieyc
     @Description: 简单的队列
     @Date:17:49 2018/3/8
     **/
    public  void TestBasicQueue(){
        Queue<String> queue=new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        for (String q:queue) {
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("第一个元素："+queue.poll());//返回第一个元素，并且在队列里删除
        for (String q:queue) {
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("第一个元素element 方法："+queue.element());//返回第一个元素，如果队列为空，则抛出一个NoSuchElementException异常
        System.out.println("第一个元素peek 方法："+queue.peek());//返回第一个元素，如果队列为空，返回null
    }




    /**
     @Author:nieyc
     @Description: 阻塞队列，put() 放入队列，如果队列满了，则阻塞等待，take() 从队列取值，如果队列为空，则等待
                    ArrayBlockingQueue 需要一个初始化的数值，来固定队列大小
                    参考：//https://www.cnblogs.com/KingIceMou/p/8075343.html
     @Date:17:55 2018/3/9
     **/
     public void   TestArrayBlockingQueue(){
         BlockingQueue queue=new ArrayBlockingQueue(3);
         try {
             queue.put("a");
             queue.put("b");
             queue.put("c");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         //queue.clear();//清空队列
         try {
            for(Object c:queue){
                String headValue=(String)queue.take();
                System.out.println("headValue:"+headValue);
                System.out.println(c.toString());
            }
         } catch (Exception e) {
             e.printStackTrace();
         }

     }

     /**
      @Author:nieyc
      @Description:如果指定一个初始化大小，就是有边界的，否则默认是Integer.MAX_VALUE,不指定大小很容易内存耗尽而死
                    其他用法和ArrayBlockingQueue 类似，都会阻塞
      @Date:18:15 2018/3/9
      **/
    public void TestLinkedBlockingQueue(){
       BlockingQueue linkQueue=new LinkedBlockingQueue();
        try {
            for (int i = 0; i <10 ; i++) {
                System.out.println(i);
                linkQueue.put(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size():"+linkQueue.size());
        try {
            for(Object c:linkQueue){
                Integer headValue=(Integer)linkQueue.take();
                System.out.println("headValue:"+headValue);
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QueueTest main=new QueueTest();
       // main.TestBasicQueue();
       // main.TestArrayBlockingQueue();
        main.TestLinkedBlockingQueue();




    }
}
