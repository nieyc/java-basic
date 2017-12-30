package reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

//http://www.importnew.com/17616.html
public class TestReflex {
	

	/**
	 * 通过反射机制获取java对象的基本属性
	 * @author nyc
	 * @date 2017年12月30日 下午9:36:10
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException 
	 * @since 0.1
	 * @see
	 */
	//@Test
	public void TestFieldAndMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class<?> clazz =Class.forName("reflex.Person");
		Object o=clazz.newInstance();
		System.out.println("o"+o);
		Field f=o.getClass().getDeclaredField("name");
		System.out.println("根据字段名获取已经声名的属性："+f);
		Field[] f1=o.getClass().getDeclaredFields();
		for(Field field:f1) {
			System.out.println(field);
		}
		System.out.println("获取已经声名的所有属性");
		Method[] m=  o.getClass().getMethods();		
		for (int i = 0; i < m.length; i++) {
		   System.out.println(m[i].getName());	
		}
		System.out.println("获取所有的方法，包括自定义的和系统自带的");
	}
	
	
	//@Test
	public void TestUpdateField() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Person person =new Person();  
        person.setName("nieyc");  
        person.setAge(24);  
        person.setSex("男");
		Field f=person.getClass().getDeclaredField("name");
		System.out.println(f.get(person));
		Field []f1=person.getClass().getDeclaredFields();  
        for(Field field:f1)  
        {  
            field.setAccessible(true); //访问私有变量成员必须先设定访问权限 
            System.out.println(field.get(person));  
        }
        System.out.println("----修改name属性------");  
        f.set(person, "李四");  
        //修改后再遍历各属性的值  
        Field []f2=person.getClass().getDeclaredFields();  
        for(Field fields:f2)  
        {  
            fields.setAccessible(true);  
            System.out.println(fields.get(person));  
        }      

	}
	
	/**
	 * 动态修改属性值
	 * @author nyc
	 * @date 2017年12月30日 下午10:18:46
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException 
	 * @since 0.1
	 * @see
	 */
	//@Test
	public void TestUpdateField1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
	
		Class<?> clazz =Class.forName("reflex.Person");
		Object o=clazz.newInstance();
		Field f1=o.getClass().getDeclaredField("name");
		f1.set(o, "张三");
		Field f2=o.getClass().getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(o, 15);
		Field f3=o.getClass().getDeclaredField("sex");
		f3.setAccessible(true);
		f3.set(o, "男");
		System.out.println(o);
	    f1.set(o, "李四"); 
	    f2.set(o, 30); 
	    f3.set(o, "女");
	    System.out.println("动态修改姓名为李四");
		Field[] f=o.getClass().getDeclaredFields(); 
		for(Field fields:f)  
        {  
			fields.setAccessible(true); 
            System.out.println(fields.get(o));
        } 
	}
	
	/**
	 * 调用方法
	 * @author nyc
	 * @date 2017年12月30日 下午10:40:37
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException 
	 * @since 0.1
	 * @see
	 */
	@Test
	public void TestMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
	NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Class<?> clazz =Class.forName("reflex.Person");
		Object o=clazz.newInstance();
		Method[] m=o.getClass().getMethods();
		//获取所有的方法
		for(Method method:m){  		
             System.out.println(m);
        } 
		
		//调用其中一个方法
		Method sayMethod =clazz.getMethod("say", new Class[] { String.class,String.class });  
		sayMethod.invoke(o, new Object[] { "张三","女" });
	}


}
