package thread.demo.good;

import java.util.concurrent.Callable;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:32 2018/1/16
 * @Description
 **/
public class ProduceGood implements Callable<String> {
    private Good good;

    public  ProduceGood(Good good){
        this.good=good;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        this.createGood();
        String gooddesc=  "生产了第"+good.getId()+"商品id:"+good.getGoodName();
        //System.out.println(gooddesc);
        return gooddesc;
    }

    public  void createGood(){
        //do something;
        for(int i=0;i<10000;i++);
        System.out.println("生产了第"+good.getId()+"个商品,商品名称："+good.getGoodName());
    }
}
