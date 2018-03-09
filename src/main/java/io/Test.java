package io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:54 2018/2/28
 * @Description
 **/
public class Test {

    public static void main(String[] args) {
      // ReadTest();
        InputStreamReaderTest();
    }

    public static void ReadTest(){
        byte[] buf = new byte[512];
        System.out.println("hey, may I have your name, please? ");
        int n = 0;
        try {
            n = System.in.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("hello, ");
        System.out.write(buf, 0, n);
    }

    public  static void InputStreamReaderTest(){
        char[] cbuf=new char[256];
        System.out.println("Hey,May I have your name?");
        int n=0;
        Reader r=new InputStreamReader(System.in);
        try {
            n=r.read(cbuf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hello, Mr. " + cbuf[0]);

    }
}
