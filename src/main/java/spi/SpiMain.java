package spi;

import java.util.ServiceLoader;

import spi.impl.Cat;

public class SpiMain {
	 public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	        
		  //使用java的SPI机制加载IShout 的实现类，/resources/META—INF/spi.Shout 文件
		  ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
	        for (IShout s : shouts) {
	            s.shout();
	        }
	        //通过编码方式
	        IShout catShout=new Cat();
	        catShout.shout();
	        //通过反射机制
	        IShout cat= (IShout)Class.forName("spi.impl.Cat").newInstance();
	        cat.shout();
	    }
}
