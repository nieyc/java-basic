package design.Strategy;

import java.util.Arrays;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:26 2018/6/8
 * @Description:冒泡排序法
 **/
public class BubbleSort implements  Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
       /* int[] myArray={2,7,9,5,11,6,8,1};
        for (int i = 0; i <myArray.length ; i++) {
            for (int j = i+1; j <myArray.length ; j++) {
                if (myArray[i]>myArray[j]){
                    int temp=0;
                    temp=myArray[j];
                    myArray[j]=myArray[i];
                    myArray[i]=temp;
                }
            }
        }
        System.out.println(myArray);*/
    }
}
