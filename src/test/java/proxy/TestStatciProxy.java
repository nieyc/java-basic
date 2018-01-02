package proxy;

import org.junit.Test;

import proxy.staticProxy.Subject;
import proxy.staticProxy.SubjectProxy;

public class TestStatciProxy {
	@Test
	public void test() {
		Subject subjectProxy=new SubjectProxy();
		subjectProxy.doSomeThing();
		
	}
}
