package dataStructure.queue.message;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;


/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:33 2018/3/14
 * @Description
 **/
public class CircleQueue<E> {
    public  int currentIndex;
    public Set<Task> taskSet =new HashSet<Task>();
    //public int circleNum;
    public CircleQueue() {
    }

    public void put(Task task){
        taskSet.add(task);
    }

    public int getSize(){
        return taskSet.size();
    }

}
