package dataStructure.queue.message;

import java.util.Iterator;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:32 2018/3/14
 * @Description
 **/
public class TimerCircleTask extends java.util.TimerTask {

     public   CircleQueue circleQueue=null;

     public  int count=0;



     public TimerCircleTask(CircleQueue circleQueue){
        this.circleQueue=circleQueue;
      }

    @Override
    public void run() {
        circleQueue.currentIndex++;
        System.out.println("指针："+circleQueue.currentIndex);

        Iterator<Task> it = circleQueue.taskSet.iterator();
        while (it.hasNext()){
            Task t=it.next();
           // System.out.println("t.taskName:"+t.taskName);
            if(t.delayTime==circleQueue.currentIndex){
                if(t.circleNum==0){
                    //System.out.println(" 当前指针"+circleQueue.currentIndex+ " 当前圈数:"+t.circleNum+ "  name:"+t.taskName+"  circleNum:"+t.circleNum+"  delayTime:"+t.delayTime);
                    System.out.println("开始执行任务:"+t.taskName);
                    it.remove();
                }else{
                    t.circleNum--;
                    continue;
                }
            }
            if(circleQueue.getSize()==0){
                System.out.println("目前没有需要执行的任务。。。。。");
            }
        }

        if(circleQueue.currentIndex==100){
            circleQueue.currentIndex=0;
            count++;
            System.out.println("当前圈数："+count+"size:"+circleQueue.getSize());
        }
    }
}
