package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 在程序运行时运用反射机制动态创建而成
 * @author nyc
 * @version 0.1 (2018年1月1日 下午9:54:31)
 * @since 0.1
 * @see
 */
public class ProxyHandler  implements InvocationHandler{


	private Object tar;

	// 绑定委托对象，并返回代理类
	public Object bind(Object tar) {
		this.tar = tar;
		// 绑定该类实现的所有接口，取得代理类
		return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		// 这里就可以进行所谓的AOP编程了
		// 在调用具体函数方法前，执行功能处理
		result = method.invoke(tar, args);
		// 在调用具体函数方法后，执行功能处理
		return result;
	}

}
