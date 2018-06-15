package design.Strategy;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:42 2018/6/14
 * @Description:快速排序
 **/
public class QuickSort implements Sorter {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int begin, int end) {
        if (begin >= end)
            return;

        int k = partition(arr, begin, end);
        quickSort(arr, begin, k-1);
        quickSort(arr, k + 1, end);
    }

    public int partition(int[] arr, int begin, int end) {
        int x = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= x) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        int t = arr[end];
        arr[end] = arr[i + 1];
        arr[i+1] = t;

        return i + 1;
    }
}
