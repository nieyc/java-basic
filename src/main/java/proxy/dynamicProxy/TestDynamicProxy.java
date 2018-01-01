package proxy.dynamicProxy;

import org.junit.Test;

public class TestDynamicProxy {
	
	@Test
	public void test() {
		ProxyHandler proxy = new ProxyHandler();
        //绑定该类实现的所有接口
        Subject sub = (Subject) proxy.bind(new SubjectImpl());
        sub.doSomething();
        sub.sayHello();
	}

}
