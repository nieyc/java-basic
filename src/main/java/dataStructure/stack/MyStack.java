package dataStructure.stack;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:15 2018/3/2
 * @Description
 **/
public class MyStack {
    private int[] data;
    private int size;
    private int top = 0; // 指向栈的顶部

    public MyStack(int size) {
        this.size = size;
        this.data = new int[size];
    }

    public void push(int num) {
        data[top++] = num;
    }
    public int pop() {
        if(top>=1){
            data[top]=0;
            return data[--top];
        }else{
            return  0;
        }
    }

    public int getTop() {
        if(top>=1){
            return data[top-1];
        }else{
            return 0;
        }

    }

    public boolean isEmpty() {
        return top == 0;
    }
}
