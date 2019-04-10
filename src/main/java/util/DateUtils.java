package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
* <p>Title: DateUtils.java</p>  
* <p>Description:SimpleDateFormat 是线程不安全的类，如果作为静态对象写在类里，就会引发线程安全问题，这个类就是有状态的，线程不安全
*     方法1：对SimpleDateFormat 对象加同步锁，
*     方法2：每次使用时候单独创建对象
*     方法3：引入ThreadLocal 
*     方法4：使用jdk8新加的类DateTimeFormatter 来替换，这也是阿里开发手册推荐的用法
*  </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: cssweb.sh.cn</p>  
* @author nieyc  
* @date 2019年4月10日  
* @version 1.0
 */
public class DateUtils {
	
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String formatDate(Date date) throws ParseException {
        return sdf.format(date);
    }

	/**
	 * 
	 * <p>线程不安全的 </p>  
	 * @param strDate
	 * @return
	 * @throws ParseException
	 * @author nieyc 
	 * @date 2019年4月10日
	 */
    public static  Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }
    
    /**
     * 
     * <p>改造成线程安全的方法，简单粗暴，但是缺点是并发大的时候会造成阻塞 </p>  
     * @param strDate
     * @return
     * @throws ParseException
     * @author nieyc 
     * @date 2019年4月10日
     */
    public static Date syncParse(String strDate) throws ParseException {
    	synchronized(sdf) {
    		return sdf.parse(strDate);
    	}
    }
    
    
    
    /**
     * 
     * <p>每次都创建一个对象也可以保证线程安全 </p>  
     * @param strDate
     * @return
     * @throws ParseException
     * @author nieyc 
     * @date 2019年4月10日
     */
    public Date noStaticParse(String strDate) throws ParseException {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return sdf.parse(strDate);
    }
    
    
    /**
     * 改造成本地线程副本，也可以保证线程安全
     */
	private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    }
	};
	
	
	
	public static Date localParse(String dateStr) throws ParseException {
	    return threadLocal.get().parse(dateStr);
	}

	public static String format(Date date) {
	    return threadLocal.get().format(date);
	}
    
	
	/** jdk 1.8引入的线程安全类**/
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static String formatDate2(LocalDateTime date) {
        return formatter.format(date);
    }

    public static LocalDateTime parse2(String dateNow) {
        return LocalDateTime.parse(dateNow, formatter);
    }
	
    
    
    
    public static void main(String[] args) throws InterruptedException, ParseException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
				@Override
				public void run() {
					  for (int j = 0; j < 10; j++) {
						 try {
							System.out.println(localParse("2018-01-02 09:45:59"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					  }
				}
			});
        }
        // 等待上述的线程执行完
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }
	

}
