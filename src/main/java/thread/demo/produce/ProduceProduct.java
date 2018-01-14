package thread.demo.produce;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in ${Time} ${Date}
 * @Description
 **/
public class ProduceProduct implements  Runnable {
    Product p=null;
    public ProduceProduct (Product p){
        this.p=p;
    }
    @Override
    public void run() {
        for (int i = 1; i <=50; i++) {
            if(i%2==0){
               p.push(i,"商品"+i);
            }else{
                p.push(i,"商品"+i);
            }
            System.out.println("生产了第"+i+"个产品,"+"名称："+p.getName());
        }

    }
}
