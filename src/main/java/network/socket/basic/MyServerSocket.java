package network.socket.basic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
	
	public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(9999);
            while(true){

                System.out.println("准备接收一个数据...");
                Socket s = server.accept();//阻塞式方法
                System.out.println("接收了一个数据...");

                //读--从客户端读数据
                InputStream in =  s.getInputStream();
                byte buf[] = new byte[1024];
                in.read(buf);
                System.out.println("read info: "+new String(buf));

                //写--应答客户端--向他写数据
                OutputStream out = s.getOutputStream();
                DataOutputStream dout = new DataOutputStream(out);
                dout.writeUTF("你好，"+s.getInetAddress().getHostAddress()+"  ,你的信息已收到。");
                dout.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
