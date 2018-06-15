package design.Strategy;

import java.util.Arrays;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:58 2018/6/15
 * @Description
 **/
public class Quick {

    public static int[] change(int[] arr){
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={66,  13 , 51,  76,  81,  26 , 57 , 23,  69};
        int left=0;
        int right=arr.length-1;
        int key=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[right]<key){
                int temp=0;
                temp=arr[right];
                arr[right]=key;
                arr[0]=temp;
            }
            if(key<arr[i]){
                int temp=0;
                temp=arr[i];
                arr[i]=key;
                arr[left]=temp;
            }
            right--;
            left++;
            if(right==left){
                key=arr[0];
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
