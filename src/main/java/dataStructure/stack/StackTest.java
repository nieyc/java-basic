package dataStructure.stack;

import java.io.IOException;
import java.util.Stack;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:47 2018/3/2
 * @Description
 **/
public class StackTest {

    public static void main(String[] args) throws IOException {

        byte[] buf=new byte[128];
        int length=System.in.read(buf);
        MyStack s=new MyStack(128);

        for (int i = 0; i < length; i++){
            System.out.println("buf[i] is=>"+buf[i]);
            if (buf[i] == '(' || buf[i] == '[' || buf[i] == '{') {
                s.push(buf[i]);
            } else if (buf[i] == ')') {
                if (s.getTop() == '(')
                    s.pop();
                else {
                    System.out.println("1 unmatch!");
                    System.exit(1);
                }
            } else if (buf[i] == ']') {
                if (s.getTop() == '[')
                    s.pop();
                else {
                    System.out.println("2 unmatch!");
                    System.exit(1);
                }
            } else if (buf[i] == '}') {
                if (s.getTop() == '{')
                    s.pop();
                else {
                    System.out.println("3 unmatch!");
                    System.exit(1);
                }
            }
        }

        if (!s.isEmpty()){
            System.out.println("4 unmatch!");
        } else{
            System.out.println("matched~");
        }


    }
}
