package dataStructure.queue.message;

import java.util.Set;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:02 2018/3/21
 * @Description
 **/
public class TimeTask extends java.util.TimerTask  {

    @Override
    public void run() {

        for (int i = 0; i <Task.circleQueue.taskList.size() ; i++) {
            Task task=(Task)Task.circleQueue.taskList.get(i);
            System.out.println(" 当前指针"+Task.circleQueue.currentIndex+ " 当前圈数:"+task.circleNum+ "  name:"+task.taskName+"  circleNum:"+task.circleNum+"  delayTime:"+task.delayTime);
            if(task.delayTime==Task.circleQueue.currentIndex){
                if(task.circleNum==0){
                    System.out.println("开始执行任务:"+task.taskName);
                    Task.circleQueue.taskList.remove(i);
                }else{
                    task.circleNum--;
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
