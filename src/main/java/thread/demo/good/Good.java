package thread.demo.good;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 10:31 2018/1/16
 * @Description
 **/
public class Good {
    private  int id;
    private  String goodName;


    public  Good(int id,String name){
        this.id=id;
        this.goodName=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }



}
