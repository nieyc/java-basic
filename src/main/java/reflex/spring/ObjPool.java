package reflex.spring;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.CharStreams;
import reflex.Person;

public class ObjPool {

	
	private Map<String, Object> pool;
	 
    private ObjPool(Map<String, Object> pool) {
        this.pool = pool;
    }
 
    private static JSONArray getObjects(String config) throws IOException {
        Reader reader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(config));
        return JSONObject.parseObject(CharStreams.toString(reader)).getJSONArray("bean");
    }
 
    private static Object getInstance(String className, JSONArray fields)
            throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
 
        // 配置的Class
        Class<?> clazz = Class.forName(className);
        // 目标Class的实例对象
        Object targetObject = clazz.newInstance();
        if (fields != null && fields.size() != 0) {
            for (int i = 0; i < fields.size(); ++i) {
                JSONObject field = fields.getJSONObject(i);
                // 需要设置的成员变量名
                String fieldName = field.getString("name");
               
 
                // 需要设置的成员变量的值
                Object fieldValue;
                if (field.containsKey("value")) {
                    fieldValue = field.get("value");
                } else if (field.containsKey("ref")) {
                    String refBeanId = field.getString("ref");
                    fieldValue = OBJECTPOOL.getObject(refBeanId);
                } else {
                    throw new RuntimeException("neither value nor ref");
                }
 
                String setterName = "set" +
                        fieldName.substring(0, 1).toUpperCase() +
                        fieldName.substring(1);
                // 需要设置的成员变量的setter方法
                Method setterMethod = clazz.getMethod(setterName, fieldValue.getClass());
                // 调用setter方法将值设置进去
                setterMethod.invoke(targetObject, fieldValue);
            }
        }
 
        return targetObject;
    }
 
    private static ObjPool OBJECTPOOL;
 
    // 创建一个对象池的实例(保证是多线程安全的)
    private static void initSingletonPool() {
        if (OBJECTPOOL == null) {
            synchronized (ObjPool.class) {
                if (OBJECTPOOL == null) {
                    OBJECTPOOL = new ObjPool(new ConcurrentHashMap<String, Object>());
                }
            }
        }
    }
 
    // 根据指定的JSON配置文件来初始化对象池
    public static ObjPool init(String config) {
        // 初始化pool
        initSingletonPool();
 
        try {
            JSONArray objects = getObjects(config);
            for (int i = 0; objects != null && i < objects.size(); ++i) {
                JSONObject object = objects.getJSONObject(i);
                if (object == null || object.size() == 0) {
                    continue;
                }
                String id = object.getString("id");
                String className = object.getString("class");
 
                // 初始化bean并放入池中
                OBJECTPOOL.putObject(id, getInstance(className, object.getJSONArray("fields")));
            }
            return OBJECTPOOL;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    public Object getObject(String id) {
        return pool.get(id);
    }
 
    public void putObject(String id, Object object) {
        pool.put(id, object);
    }
 
    public void clear() {
        pool.clear();
    }
    
    
    public static void main(String[] args) {
    	ObjPool pool = ObjPool.init("config_field.json");
         Person person = (Person) pool.getObject("person");
         System.out.println(person);
  
         User user = (User) pool.getObject("user");
         System.out.println(user);
  
         ComplexBean complexBean = (ComplexBean) pool.getObject("comlex");
         System.out.println(complexBean);
	}
}
