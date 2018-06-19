package design.Strategy;

import java.util.Arrays;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:58 2018/6/15
 * @Description:挖坑理解
 * https://blog.csdn.net/morewindows/article/details/6684558
 **/

public class Quick
{
    public static void main(String args[])
    {
        Quick quicksort = new Quick();
        //int[] arrays = new int[]{ 9, 12, 2, 13, 3, 14, 4, 15, 5, 16,  17, 177, 18, 8, 19 };
        int[] arrays = new int[]{ 9, 12, 2, 13, 3, 14, 4};
        quicksort.quickSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private void quickSort(int[] arrays)
    {
        subQuickSort(arrays, 0, arrays.length - 1);
    }

    private void subQuickSort(int[] arrays, int start, int end)
    {
        if (start >= end) {
            return;
        }
        int middleIndex = subQuickSortCore(arrays, start, end);
        subQuickSort(arrays, start, middleIndex - 1);
        subQuickSort(arrays, middleIndex + 1, end);
    }

    private int subQuickSortCore(int[] arrays, int start, int end)
    {
        int middleValue = arrays[start];
        while (start < end)
        {
            while (arrays[end] >= middleValue && start < end)
            {
                end--;
            }
            arrays[start] = arrays[end];
            while (arrays[start] <= middleValue && start < end)
            {
                start++;
            }
            arrays[end] = arrays[start];
        }
        arrays[start] = middleValue;
        return start;
    }
}