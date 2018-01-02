package proxy;

import org.junit.Test;

import proxy.dynamicProxy.ProxyHandler;
import proxy.dynamicProxy.Subject;
import proxy.dynamicProxy.SubjectImpl;

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
