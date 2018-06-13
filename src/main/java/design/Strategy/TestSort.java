package design.Strategy;

import java.util.Arrays;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:12 2018/6/8
 * @Description:策略模式，一个接口有多个实现
 **/
public class TestSort {
    public static void main(String[] args) {
        int[] myArray = {1, 4, 3, 7, 5, 8, 6, 2};
       // Sorter s=new BubbleSort();
        //Sorter s=new InsertionSorter();
       // Sorter s=new SelectionSort();
        Sorter s=new QueueSort();
        s.sort(myArray);
        Arrays.stream(myArray).forEach(System.out::println);
    }
}
