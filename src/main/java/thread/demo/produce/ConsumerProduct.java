package thread.demo.produce;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class ConsumerProduct  implements  Runnable {

    Product p=null;
    public ConsumerProduct (Product p){
        this.p=p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
           p.pop();

        }
    }
}
