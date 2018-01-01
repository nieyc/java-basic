package proxy.staticProxy;

import org.junit.Test;

public class TestStaticProxy {
	
	@Test
	public void test() {
		Subject subjectProxy=new SubjectProxy();
		subjectProxy.doSomeThing();
		
	}

}
