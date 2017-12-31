package reflex.spring;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.CharStreams;



/**
 * 模拟了一个spring简单实现
 * @author nyc
 * @version 0.1 (2017年12月31日 下午3:34:38)
 * @since 0.1
 * @see http://www.importnew.com/17616.html
 */
public class ObjectPool {
	
	private Map<String, Object> poolMap=new ConcurrentHashMap<String, Object>();
	
	public ObjectPool() {
	}
	
	/*private ObjectPool(Map<String, Object> pool) {
	        this.poolMap = pool;
	}*/
	/**
	 * 通过反射获取对象
	 * @author nyc
	 * @date 2017年12月31日 下午2:57:56
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException 
	 * @since 0.1
	 * @see
	 */
	private  Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(className).newInstance();
    }
	
	/**
	 * 读取json文件
	 * @author nyc
	 * @date 2017年12月31日 下午2:58:09
	 * @param config
	 * @return
	 * @throws IOException 
	 * @since 0.1
	 * @see
	 */
	public  JSONArray LoadConfigFile(String config) throws IOException {
		InputStream in = ClassLoader.getSystemResourceAsStream(config);
		Reader reader = new InputStreamReader(in);
		return JSONObject.parseObject(CharStreams.toString(reader)).getJSONArray("bean");
	}
	

	

	
	public  Map<String, Object>  init(String config) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		JSONArray jsonArray=LoadConfigFile(config);
		if(jsonArray!=null) {
          for (int i = 0; i < jsonArray.size(); i++) {
			 JSONObject jobj=  (JSONObject)jsonArray.get(i);
			 poolMap.put(jobj.getString("id"), getInstance(jobj.getString("class")));
		   }
		}
		return poolMap;
	}
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		ObjectPool obj=new ObjectPool();
		Map<String, Object> map=obj.init("config.json");
		System.out.println(map);
		User user = (User) map.get("user");
		user.setName("liyiwen");
        System.out.println(user.toString());
 
	}

}
