package thread.demo.produce;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class TestProduct {

    public static void main(String[] args) {
        Product product=new Product();
        ProduceProduct p=new ProduceProduct(product);
        ConsumerProduct c=new ConsumerProduct(product);
        Thread tp=new Thread(p);
        Thread tc=new Thread(c);
        tp.start();
        tc.start();
    }
}
