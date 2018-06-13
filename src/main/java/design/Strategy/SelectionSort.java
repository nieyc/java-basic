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



     /**
       @Author:nieyc
       @Description: 选择排序，实现从小到大
       @Date:14:02 2018/6/11
      **/
    public static void main(String[] args) {
        int[] arr={9,7,11,8,5,6,2,1};
        int pivot,pos=-1;
        for (int i = 0; i <arr.length ; i++) {
            pivot=Integer.MAX_VALUE;
            for (int j=i;j<arr.length;j++){
                if(pivot>arr[j]){
                    pos=j;
                    pivot=arr[j];
                }
            }
            arr[pos]=arr[i];
            arr[i]=pivot;
            System.out.println(arr);

        }
        System.out.println(arr);

    }
}
