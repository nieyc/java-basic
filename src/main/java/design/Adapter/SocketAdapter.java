package design.Adapter;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 9:50 2018/3/1
 * @Description
 * 适配器模式：对象适配器模式
 * 当我们要访问的接口A中没有我们想要的方法 ，却在另一个接口B中发现了合适的方法，我们又不能改变访问接口A，
 * 在这种情况下，我们可以定义一个适配器p来进行中转，这个适配器p要实现我们访问的接口A，这样我们就能继续
 * 访问当前接口A中的方法（虽然它目前不是我们的菜），然后在适配器P中定义私有变量C（对象）（B接口指向变量名），
 * 再定义一个带参数的构造器用来为对象C赋值，再在A接口的方法实现中使用对象C调用其来源于B接口的方法。
 *
 * @see SocketAdapter1 类适配器模式
 * @see design.Adapter.IAdapter.TestAdapter 接口适配器模式
 **/
public class SocketAdapter implements  DBSocketInterface {

    //组合新接口
    private GBSocketInterface gbSocket;
    /**
     * 在创建适配器对象时，必须传入一个新接口的实现类
     * @param gbSocket
     */
    public SocketAdapter(GBSocketInterface gbSocket) {
        this.gbSocket = gbSocket;
    }

    @Override
    public void powerWithTwoRound() {
      gbSocket.powerWithThreeFlat();
    }
}
