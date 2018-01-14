package rpc.server;

import java.io.IOException;

import rpc.RpcFramework;

public class RpcServer {
	public static void main(String[] args) {
        try {
            //暴露服务
            HelloService service = new HelloServiceImpl();
            RpcFramework.export(service, 8989);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
