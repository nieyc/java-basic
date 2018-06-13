package generic;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:26 2018/6/13
 * @Description 定义一个泛型类
 **/
public class Generic<T> {

    private T key;

    public Generic(T key){
        this.key=key;
    }

    public  T getKey(){
        return this.key;
    }
}
