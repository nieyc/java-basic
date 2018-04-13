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

    public long delayTime;

    public static CircleQueue circleQueue=new CircleQueue();//全局集合

    public Task(String taskName,int circleNum,long delayTime){
        this.taskName=taskName;
        this.circleNum=circleNum;
        this.delayTime=delayTime;
    }

}
