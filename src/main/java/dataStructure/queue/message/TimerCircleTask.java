package dataStructure.queue.message;

import java.util.Iterator;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 13:32 2018/3/14
 * @Description set集合一边放入，一边删除，会出现问题，改为放入list中
 **/
public class TimerCircleTask extends java.util.TimerTask {




    @Override
    public void run() {

        System.out.println("指针："+Task.circleQueue.currentIndex+"queue.size():"+Task.circleQueue.getSize());

            Iterator<Task> it = Task.circleQueue.taskSet.iterator();
            while (it.hasNext()){
                Task t=it.next();
                System.out.println(" 当前指针"+Task.circleQueue.currentIndex+ " 当前圈数:"+t.circleNum+ "  name:"+t.taskName+"  circleNum:"+t.circleNum+"  delayTime:"+t.delayTime);
                if(t.delayTime==Task.circleQueue.currentIndex){
                    if(t.circleNum==0){
                        System.out.println("开始执行任务:"+t.taskName);
                        it.remove();
                    }else{
                        t.circleNum--;
                        continue;
                    }
                }
                if(Task.circleQueue.getSize()==0){
                    System.out.println("目前没有需要执行的任务。。。。。");
                }

            }
            Task.circleQueue.currentIndex++;


        if(Task.circleQueue.currentIndex==60){
            Task.circleQueue.currentIndex=0;
            System.out.println("size:"+Task.circleQueue.getSize());
        }
    }
}
