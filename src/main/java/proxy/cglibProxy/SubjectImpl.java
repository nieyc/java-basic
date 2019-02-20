package proxy.cglibProxy;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:43 2019/2/20
 * @Description
 **/
public class SubjectImpl implements  Subject {
    @Override
    public void doSomething() {
        System.out.println("i am cglib proxy method");
    }

    @Override
    public final void sayHello() {
        System.out.println("i am final method");
    }
}
