package org.picenter.pictest;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.picenter.pictest.testclass.TestInheritA;


public class Obj2MapDemo {

	public static void main(String[] args) throws Exception {
		TestInheritA ca = new TestInheritA("stra_aaa", 1, new Date(), "strina_aaa", 2);
		Map<String, Object> map1 = obj2Map(ca);
		
		Map<String, String> map2 = new HashMap<String, String>();
		DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		for (String key : map1.keySet()) {
			System.out.println(key + " : " + map1.get(key));
		}
		for (String key : map1.keySet()) {
			if (map1.get(key) instanceof Date) {
				map2.put(key, df.format((Date) map1.get(key)));
				System.out.println(df.format((Date) map1.get(key)));
			} else {
				map2.put(key, String.valueOf(map1.get(key)));
			}
		}
		for (String key : map2.keySet()) {
			System.out.println(key + " : " + map2.get(key));
		}
	}

	public static Map<String, Object> Obj2Map(Object obj) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}
		return map;
	}

	public static Object map2Obj(Map<String, Object> map, Class<?> clz) throws Exception {
		Object obj = clz.newInstance();
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}
			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));
		}
		return obj;
	}
	
	public static Map<String,Object> obj2Map(Object obj) throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
         for (PropertyDescriptor property : propertyDescriptors) { 
             String key = property.getName();
             if (key.compareToIgnoreCase("class") == 0) {   
                    continue;  
                }  
                 Method getter = property.getReadMethod();  
                Object value = getter!=null ? getter.invoke(obj) : null;  
                map.put(key, value); 
         }
        return map;
    }

}