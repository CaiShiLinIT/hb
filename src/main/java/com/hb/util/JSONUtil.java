package com.hb.util;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json串和对象互相转换的工具类
 */
public class JSONUtil {
    /**
     * 初始化静态成员属性
     */
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 把对象转成json串
     * @param obj 传入需要转成json串的对象
     * @return
     */
    public static String toJson(Object obj){
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * 把json串转成对象
     * @param json 传入需要转成对象的json串
     * @param cla 指定实例的类对象
     * @param <T> 返回类型
     * @return
     */
    public static <T> T toObject(String json, Class<T> cla){
        T data = null;
        try {
            data = mapper.readValue(json, cla);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return data;
    }
}
