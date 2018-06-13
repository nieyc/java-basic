package generic;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 14:42 2018/6/13
 * @Description
 **/
public class FruitGenerator implements  Generator<String> {

   String[] fruit={"apple","banana","pear"};
    @Override
    public String next() {
        return fruit[0];
    }
}
