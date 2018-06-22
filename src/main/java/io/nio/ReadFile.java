package io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:03 2018/6/20
 * @Description
 **/
public class ReadFile {

     /**
       @Author:nieyc
       @Description: nio 读取文件
       @Date:15:25 2018/6/20
      **/
    public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("D:\\log\\141\\stdout.log","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);//分配缓冲区空间
            int bytesRead = fileChannel.read(buf);//写入数据到缓冲区
            System.out.println(bytesRead);//每次写入1024个字节
            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining()) {
                   System.out.print((char)buf.get());//从buf中读取数据
                }
               // System.out.println(new String(buf.array(),"UTF-8"));

                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }




     /**
       @Author:nieyc
       @Description: 传统的io读取文件
       @Date:15:25 2018/6/20
      **/
    public static void method2(){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("D:\\log\\141\\stdout.log"));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                   //for(int i=0;i<bytesRead;i++)
                   // System.out.print((char)buf[i]);
                    System.out.println(new String(buf,"UTF-8"));
                    bytesRead = in.read(buf);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        method1();
        //method2();
    }


}
