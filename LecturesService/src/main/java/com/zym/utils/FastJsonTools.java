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
 * JSONת��������
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
	 * ��fastjson ��json�ַ�������Ϊһ�� JavaBean
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
	 * ��fastjson ��json�ַ��� ������Ϊһ�� List<JavaBean> �� List<String>
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
	 * ��fastjson ��json�ַ��� ������Ϊһ�� List<JavaBean> �� List<String>
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
	 * ��fastjson ��jsonString ������ List<Map<String,Object>>
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> getListMap(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			// ����д��
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
     * @Description: ������ת��ΪJSON�ַ��� 
     * @param obj   //����ģ�� 
     * @return String   //ת����ϵ��ַ��� 
     */  
    public static String obj2Json(Object obj) {  
        String str = JSON.toJSONString(obj,mapping,SerializerFeature.WriteMapNullValue);  
        return str;  
    } 
}