package design.Strategy;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:42 2018/6/8
 * @Description：插入排序法
 **/
public class InsertionSorter implements  Sorter{
    @Override
    public void sort(int[] arr) {
        int i,j,tmp;
        for (i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = tmp;
        }
    }




}
