package thread.demo.produce;

import java.util.Random;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description 一个经典的多线程下生产者，消费者的例子。生产一个商品，消费一个商品
 **/
public class Product {

    private int id;

    private String name;

    //表示共享资源对象是否为空，如果为 true，表示需要生产，如果为 false，则有数据了，不要生产
    private boolean isEmpty=true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     @Author:nieyc
     @Description:生产一个商品
     @Date:21:38 2018/1/14
     **/
    public synchronized void push(int id,String name){
        java.util.Random random=new java.util.Random();
        try {
            while (!isEmpty){//如果有数据了，不能再生产。必须要等待消费者消费
                this.wait();
                System.out.println("生产者在等待。。。。");
            }
            this.id=id;
            Thread.sleep(random.nextInt(1000));
            this.name=name;
            isEmpty=false;//有商品了，不能再生产了
            this.notify();//生产完毕，唤醒所有消费者
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     @Author:nieyc
     @Description:消费一个商品
     @Date:21:39 2018/1/14
     **/
    public synchronized void pop(){
        java.util.Random random=new java.util.Random();
        try {
            while(isEmpty){//当没有产品的时候，不能消费，必须等生产者生产
                this.wait();
                System.out.println("消费者在等待。。。。");
            }
           Thread.sleep(random.nextInt(1000));
            System.out.println("消费了第"+this.id+"个商品：名称==>"+this.name);
            isEmpty = true;//消费完成，改变状态
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
