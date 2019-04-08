package thread.sync;


/**
 * syncronized只锁定对象，每个对象有一个lock与之关联，两把锁分别锁定t4和t44,所以可以并发执行，没有达到互斥的效果，如果要互斥，参考
 * public static void main(String[] args) {
		Thread4 t4=new Thread4();
		Thread ta=new Thread(t4, "A");
		ta.start();
		Thread tb=new Thread(t4, "B");
		tb.start();
	}
* <p>Title: Thread4.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: cssweb.sh.cn</p>  
* @author nieyc  
* @date 2019年4月8日  
* @version 1.0
 */
public class Thread4 implements Runnable{

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i <50; i++) {
				System.out.println("线程名称："+Thread.currentThread().getName());
			}
		}
		
	}
	
	public static void main(String[] args) {
		Thread4 t4=new Thread4();
		Thread4 t44=new Thread4();
		Thread ta=new Thread(t4, "A");
		ta.start();
		Thread tb=new Thread(t44, "B");
		tb.start();
	}

}
