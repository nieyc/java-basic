package proxy.cglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:41 2019/2/20
 * @Description
 * 使用JDK动态代理，目标类必须实现的某个接口，如果某个类没有实现接口则不能生成代理对象。
   Cglib原理是针对目标类生成一个子类，覆盖其中的所有方法，所以目标类和方法不能声明为final类型。
   疑问：代理除了spring里的计算方法执行时间，记录日志，还有什么场景？？？？搞不明白
 **/
public class TestCglibTest {

    public static void main(String[] args) {
        /** cglib生成的代理类输出磁盘 **/
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        CglibProxy proxy = new CglibProxy();
        SubjectImpl subject=new SubjectImpl();
        SubjectImpl proxy1=(SubjectImpl)proxy.newProxy(subject);
        proxy1.doSomething();
        /** cglib代理不支持final 方法  **/
        proxy1.sayHello();
        /** cglib代理可以直接代理一个具体类   **/
        Student student=new Student();
        Student suProxy=(Student)proxy.newProxy(student);
        suProxy.getName();
    }
}
