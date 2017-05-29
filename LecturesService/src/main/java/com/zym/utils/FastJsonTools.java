package com.zym.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * JSON转换工具类
 * 
 * @author penghuaiyi
 * @date 2014-04-04
 */
public class FastJsonTools {

	 private static SerializeConfig mapping = new SerializeConfig();   
     
	    private static String dateFormat;    
	    static {    
	        dateFormat = "yyyy-MM-dd HH:mm:ss";    
	        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));  
	    }   
	/**
	 * 用fastjson 将json字符串解析为一个 JavaBean
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T getJson(String jsonString, Class<T> cls) {
		T t = null;
		try {
			t = JSON.parseObject(jsonString, cls);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> getArrayJson(String jsonString, Class<T> cls) {
		List<T> list = new ArrayList<T>();
		try {
			list = JSON.parseArray(jsonString, cls);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/**
	 * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getArrayJson(String jsonString) {
		List<T> list = new ArrayList<T>();
		try {
			list = (List<T>) JSON.parseArray(jsonString);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/**
	 * 用fastjson 将jsonString 解析成 List<Map<String,Object>>
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> getListMap(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			// 两种写法
			// list = JSON.parseObject(jsonString, new
			// TypeReference<List<Map<String, Object>>>(){}.getType());

			list = JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}  
	/** 
     * @Title: obj2Json 
     * @Description: 将对象转换为JSON字符串 
     * @param obj   //对象模型 
     * @return String   //转换完毕的字符串 
     */  
    public static String obj2Json(Object obj) {  
        String str = JSON.toJSONString(obj,mapping,SerializerFeature.WriteMapNullValue);  
        return str;  
    } 
}