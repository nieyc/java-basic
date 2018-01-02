package proxy.staticProxy;



public class TestStaticProxy {
	
	
	public static void main(String[] args) {
		Subject subjectProxy=new SubjectProxy();
		subjectProxy.doSomeThing();
	}

}
