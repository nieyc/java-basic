package network.socket.basic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClientSocket {
	
	public static void main(String[] args) {
        try {
            //因为是在自己本机上演示，IP就直接填写本机10.30.7.95的了。
            //这个端口和IP都是服务器端的(自己可以改的)
            Socket s = new Socket("172.16.0.97", 9999);
            //和服务器进行三次握手，若失败则出异常，否则返回和对方通讯的socket

            OutputStream os = s.getOutputStream();
            //发送数据
            os.write("你好，服务器123！".getBytes());

            //接收服务器端的反馈
            InputStream in = s.getInputStream();

            DataInputStream din = new DataInputStream(in);

            System.out.println(din.readUTF());

            s.close();
            din.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
