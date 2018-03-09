package design.Adapter.IAdapter;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:24 2018/3/1
 * @Description:
 * 适配器模式：接口适配器模式
 * 当存在这样一个接口，我们只想调用其中一个多几个方法，而接口中定义了N多方法，如果我们直接实现接口，那么需要对
 * 接口中所有方法都实现一次，我们仅仅是对不需要的方法进行置空（只写一对大括号，不做具体方法实现）也会导致这个类
 * 变得臃肿，调用也不方便，这时我们可以使用一个抽象类作为中间件，即适配器，用这个抽象类实现接口，而在抽象类中
 * 所有的方法都进行置空，那么我们在创建抽象类的继承类，而且重写我们需要使用的那几个方法即可。
 *
 * @see design.Adapter.SocketAdapter  对象适配器模式
 * @see design.Adapter.SocketAdapter1 类适配器模式
 *
 **/
public class TestAdapter {
    public static void main(String[] args) {
        A a=new Ashili();
        a.a();
        a.d();
    }
}
