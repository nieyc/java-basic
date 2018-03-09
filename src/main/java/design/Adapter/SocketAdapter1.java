package design.Adapter;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:11 2018/3/1
 * @Description:
 *  适配器模式：类适配器模式
 *  当我们要访问接口A的时候，没有我们想要的方法，却在接口B中发现了想要的方法，但又不能改变访问接口A
 *  这种情况下，我们需要定义一个适配器P来进行中转，这个适配器P要实现我们访问的接口A，然后继承接口B的实现类BB，这样
 *  就可以在适配器P中访问接口B的方法了，这时我们在适配器P中的接口A方法中直接引用BB中的合适方法，这样就完成了一个
 *  简单的类适配器。
 *
 *  我们要在德国使用中国标准的充电器（中国是三相插座，德国是2项圆孔插座），定义一个适配器，实现了德国标准的接口，并且
 *  继承了中国标准接口的实现类
 *  @see TestAdapter 测试类
 *  @see SocketAdapter 对象适配器模式
 *  @see design.Adapter.IAdapter.TestAdapter 接口适配器模式
 **/
public class SocketAdapter1 extends GBSocket implements DBSocketInterface {
    @Override
    public void powerWithTwoRound() {
        powerWithThreeFlat();
    }
}
