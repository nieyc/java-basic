package dataStructure.heap;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:18 2018/6/12
 * @Description 最小堆
 **/
public class MinHeap {

    private int[] data;

    public MinHeap(int[] data){
     this.data=data;
     bulidHeap();
    }

    private void bulidHeap(){
        for (int i =data.length/2-1; i >=0 ; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        // 获取左右结点的数组下标
        int left = left(i);
        int right = right(i);

        // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
        int smallest = i;

        // 存在左结点，且左结点的值小于根结点的值
        if (left < data.length && data[left] < data[i]){
            smallest = left;
        }


        // 存在右结点，且右结点的值小于以上比较的较小值
        if (right < data.length && data[right] < data[smallest]){
            smallest = right;
        }


        // 左右结点的值都大于根节点，直接return，不做任何操作
        if (i == smallest){
            return;
        }


        // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
        swap(i, smallest);

        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(smallest);
    }

    // 获取右结点的数组下标
    private int right(int i) {
        return (i + 1) << 1;
    }

    // 获取左结点的数组下标
    private int left(int i) {
        return ((i + 1) << 1) - 1;
    }

    // 交换元素位置
    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    // 获取对中的最小的元素，根元素
    public int getRoot()
    {
        return data[0];
    }

    // 替换根元素，并重新heapify
    public void setRoot(int root)
    {
        data[0] = root;
        heapify(0);
    }


    public static void main(String[] args) {
        int[] arr={7,9,1,5,8,2,4,6,7,0,3};
        MinHeap heap = new MinHeap(arr);
        System.out.println(heap);
    }

}
