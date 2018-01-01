package proxy.staticProxy;

public class SubjectProxy implements Subject{

	Subject subjectImpl=new SubjectImpl();
	
	public void doSomeThing() {
		System.out.println("处理业务逻辑之前记录日志消息");
		subjectImpl.doSomeThing();
		System.out.println("处理业务逻辑之后记录日志消息");
	}
	

}
