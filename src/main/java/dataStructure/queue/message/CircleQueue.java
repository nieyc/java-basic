package dataStructure.queue.message;


import java.util.*;


/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:33 2018/3/14
 * @Description
 **/
public class CircleQueue<E> {
    public  int currentIndex;

    public Set<Task> taskSet =new HashSet<Task>();
    public List<Task> taskList=new ArrayList<Task>();

    public CircleQueue() {
    }

    public void put(Task task){
        taskList.add(task);
    }

    public int getSize(){
        return taskList.size();
    }



}
