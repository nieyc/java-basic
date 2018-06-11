package design.Strategy;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 17:38 2018/6/8
 * @Description 选择排序
 **/
public class SelectionSort implements  Sorter {

    @Override
    public void sort(int[] arr) {
        int i, j, k;
        for (i = 0; i< arr.length-1; i++) {
            k = i;
            for (j = i+1; j < arr.length; j++) {
                if (arr[k] > arr[j]){
                    k = j;
                }
            }
            if (k != i) {
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
            }
        }
    }
}
