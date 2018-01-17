package thread.demo.good;

import java.util.concurrent.Callable;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:33 2018/1/16
 * @Description
 **/
public class ConsumerGood implements Callable<String> {

    private Good good;

    public  ConsumerGood(Good good){
        this.good=good;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        this.consumGood();
        String gooddesc=  "消费了第"+good.getId()+"商品id:"+good.getGoodName();
        //System.out.println(gooddesc);
        return gooddesc;
    }

    public void consumGood(){
            //do something;
            for(int i=0;i<10000;i++);
            System.out.println("消费了第"+good.getId()+"个商品,商品名称："+good.getGoodName());
    }
}
