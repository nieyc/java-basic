package design.Strategy;

import java.util.PriorityQueue;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:33 2018/6/13
 * @Description:优先队列排序，本质是一个最小堆，数据在优先队里里是已最小堆形式组织的
 * @see dataStructure.heap.MinHeap
 **/
public class QueueSort implements  Sorter {
    @Override
    public void sort(int[] arr) {
        PriorityQueue<Integer> queue=new PriorityQueue();
        for (int i = 0; i <arr.length ; i++) {
            queue.add(arr[i]);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            arr[i++] = queue.poll();
        }
    }
}
