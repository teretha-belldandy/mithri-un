package org.picenter.pictest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.picenter.pictest.testclass.TestClassA;

import com.alibaba.fastjson.JSONObject;

public class JsonFastDemo {

	public static void main(String[] args) {
		TestClassA ca = new TestClassA("stra_aaa", 1, new Date());
		String str = JSONObject.toJSONString(ca);
		System.out.println(str);
		@SuppressWarnings("unchecked")
		Map<String, Object> map1 = JSONObject.parseObject(str, Map.class);
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

}