package dataStructure.queue.message;

import java.util.Iterator;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:35 2018/3/14
 * @Description
 **/
public class Task {

    public String  taskName;//任务名称

    public int circleNum;

    public int initCircleNum;

    public long delayTime;

    public CircleQueue queue;


    public Task(String taskName,int circleNum,long delayTime){
        this.taskName=taskName;
        this.circleNum=circleNum;
        this.delayTime=delayTime;
        initCircleNum=0;
    }
    public  Task(CircleQueue circleQueue){
      this.queue=circleQueue;
    }

   /* public void doTask(){
        Iterator<Task> it = queue.taskSet.iterator();
        while (it.hasNext()){
            Task t=it.next();
            // System.out.println("t.taskName:"+t.taskName);
            if(t.delayTime==queue.currentIndex){
                if(t.circleNum==0){
                    //System.out.println(" 当前指针"+circleQueue.currentIndex+ " 当前圈数:"+t.circleNum+ "  name:"+t.taskName+"  circleNum:"+t.circleNum+"  delayTime:"+t.delayTime);
                    System.out.println("开始执行任务:"+t.taskName);
                    it.remove();
                }else{
                    t.circleNum--;
                    continue;
                }
            }
            if(queue.getSize()==0){
                System.out.println("目前没有需要执行的任务。。。。。");
            }
        }
    }*/







}
