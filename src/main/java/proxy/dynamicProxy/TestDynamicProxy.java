package proxy.dynamicProxy;

public class TestDynamicProxy {
	
	public static void main(String[] args) {
		ProxyHandler proxy = new ProxyHandler();
        //绑定该类实现的所有接口
        Subject sub = (Subject) proxy.bind(new SubjectImpl());
        sub.doSomething();
        sub.sayHello();
	}

}
