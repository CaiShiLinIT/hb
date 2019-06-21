package com.hb.util;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Json对象互转util
 * @author Administrator
 *
 */
public class ObjectMapperUtil {
	private static final ObjectMapper MAPPER=new ObjectMapper(); 
	public static String toJson(Object object) {
		String json=null;
		try {
			json =MAPPER.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			//将检查异常转为运行异常
			throw new RuntimeException();
		}
		return json;
	}
	public static <T>T toObject(String json,Class<T> targetClass){
		T target=null;
		try {
			target=MAPPER.readValue(json, targetClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return target;
	}
}
