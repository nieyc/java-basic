package rpc.server;

public class HelloServiceImpl  implements HelloService{

	public String sayHello(String msg) {
        String result = "hello world " + msg;
        System.out.println(result);
        return result;
	}

}
