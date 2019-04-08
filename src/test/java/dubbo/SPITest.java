package dubbo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SPITest {
	
	static Map<String,Class<?>> clazzMap=new ConcurrentHashMap<String, Class<?>>();
	
	public void testClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
		Class<?> clazz=SPITest.class;
		System.out.println(clazz);
		Class<?> clazz1=Class.forName("dubbo.SPITest");
		System.out.println(clazz1);
		System.out.println(clazz1.newInstance());
		clazzMap.putIfAbsent("spiTest", clazz);
		System.out.println(clazzMap.get("spiTest"));
	}
	
	public static void main(String[] args) {
		SPITest spi=new SPITest();
		try {
			spi.testClass();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
