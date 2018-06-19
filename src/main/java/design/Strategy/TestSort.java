package design.Strategy;

import java.util.Arrays;
import java.util.Random;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:12 2018/6/8
 * @Description:策略模式，一个接口有多个实现
 * 最优的算法是快速排序，1000万个随机数，1秒钟完成快速排序，用冒泡排序从早上排到现在也没排出来。效率可见，算法的魔力体现的淋漓尽致
 **/
public class TestSort {
    public static void main(String[] args) {
       // int[] myArray = {1, 4, 3, 7, 5, 8, 6, 2};
       // Sorter s=new BubbleSort();
        //Sorter s=new InsertionSorter();
       // Sorter s=new SelectionSort();
       // Sorter s=new QueueSort();
        Long start=System.currentTimeMillis();
        int[] myArray=new int[10000000];
        Random r=new Random();
        for(int i=0;i<10000000;i++){
            myArray[i]=r.nextInt(10000000);
        }
        Sorter s=new QueueSort();
        s.sort(myArray);
        //Arrays.stream(myArray).forEach(System.out::println);
        Long end=System.currentTimeMillis();

        System.out.println(Arrays.toString(myArray));
        System.out.println("time:"+(end-start));
    }
}
