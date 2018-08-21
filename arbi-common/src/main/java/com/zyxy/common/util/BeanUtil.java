package com.zyxy.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * Class 工具类
 * 
 * @author tanquan
 *
 */
public class BeanUtil extends BeanUtils{
	private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);
	
	/**
	 * 获取对象的属性和值
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getFieldsAsMap (Object object) {
		return getFieldsAsMap(object, null, false);
	}
	
	/**
	 * 获取对象的属性和值
	 * @param object
	 * @param excludeEmptyValue 是否过滤空元素
	 * @return
	 */
	public static Map<String, Object> getFieldsAsMap (Object object, Boolean excludeEmptyValue) {
		return getFieldsAsMap(object, null, excludeEmptyValue);
	}
	
	/**
	 * 获取对象的属性和值
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getFieldsAsMap (Object object, String[] excludeFields) {
		return getFieldsAsMap(object, excludeFields, false);
	}
	
	/**
	 * 获取对象的属性和值
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getFieldsAsMap (Object object, String[] excludeFields,  Boolean excludeEmptyValue) {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			// 拿到该属性的gettet方法  
			/** 
			 * 这里需要说明一下：他是根据拼凑的字符来找你写的getter方法的 
			 * 在Boolean值的时候是isXXX（默认使用ide生成getter的都是isXXX） 
			 * 如果出现NoSuchMethod异常 就说明它找不到那个gettet方法 需要做个规范 
			 */  
			String name = field.getName();
			if (excludeFields !=null && excludeFields.length > 0 && contains(excludeFields, name)) {
				continue;
			}
			Object value = null;
			try {
				Method m = (Method) object.getClass().getMethod(  
						"get" + getMethodName(name));
				value =  m.invoke(object);
			} catch (Exception e) {
				logger.debug("property {} has no getter method", name);
			}  
			if (excludeEmptyValue && (value == null || (value instanceof String && StringUtil.isEmpty(value.toString())))) {
				continue;
			}
			map.put(name, value);
		}
		if (object.getClass().getSuperclass() != null && !"object".equalsIgnoreCase(object.getClass().getSuperclass().getSimpleName())) {
			map.putAll(getSuperClassFieldsAsMap(object, object.getClass().getSuperclass(), map, excludeFields, excludeEmptyValue));
		}
		return map;
	}
	

    /**
     * 获取对象的属性和值
     * @param object
     * @return
     */
    public static Map<String, Object> getFieldsAsHttpMap (Object object, String[] excludeFields,  Boolean excludeEmptyValue) {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 拿到该属性的gettet方法  
            /** 
             * 这里需要说明一下：他是根据拼凑的字符来找你写的getter方法的 
             * 在Boolean值的时候是isXXX（默认使用ide生成getter的都是isXXX） 
             * 如果出现NoSuchMethod异常 就说明它找不到那个gettet方法 需要做个规范 
             */  
            String name = field.getName();
            if (excludeFields !=null && excludeFields.length > 0 && contains(excludeFields, name)) {
                continue;
            }
            Object value = null;
            try {
                Method m = (Method) object.getClass().getMethod(  
                        "get" + getMethodName(name));
                value =  m.invoke(object);
            } catch (Exception e) {
                logger.debug("property {} has no getter method", name);
            }  
            if (excludeEmptyValue && (value == null || (value instanceof String && StringUtil.isEmpty(value.toString())))) {
                continue;
            }
            if (Collection.class.isAssignableFrom(value.getClass())) {
                map = getCollectionsAsHttpMap(map, name, (Collection<?>)value);
            } else {
                map.put(name, value);
            }
        }
        if (object.getClass().getSuperclass() != null && !"object".equalsIgnoreCase(object.getClass().getSuperclass().getSimpleName())) {
            map.putAll(getSuperClassFieldsAsMap(object, object.getClass().getSuperclass(), map, excludeFields, excludeEmptyValue));
        }
        return map;
    }
    
    private static Map<String, Object> getCollectionsAsHttpMap(Map<String, Object> orignMap, String collectionName, Collection<?> col) {
        Object[] objs = col.toArray();
        for (int i = 0; i < objs.length; i++) {
            Map<String, Object> objMap = getFieldsAsMap(objs[i]);
            if (objMap != null) {
                for (Entry<String, Object> entry : objMap.entrySet()) {
                    if (entry.getValue() != null) {
                        orignMap.put(collectionName + "[" + i +"]." + entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return orignMap;
    }
	
	private static Map<String, Object> getSuperClassFieldsAsMap(Object object, Class<?> clazz, Map<String, Object> map, String[] excludeFields,  Boolean excludeEmptyValue) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			// 拿到该属性的gettet方法  
			/** 
			 * 这里需要说明一下：他是根据拼凑的字符来找你写的getter方法的 
			 * 在Boolean值的时候是isXXX（默认使用ide生成getter的都是isXXX） 
			 * 如果出现NoSuchMethod异常 就说明它找不到那个gettet方法 需要做个规范 
			 */  
			String name = field.getName();
			if (excludeFields !=null && excludeFields.length > 0 && contains(excludeFields, name)) {
				continue;
			}
			Object value = null;
			try {
				Method m = (Method) clazz.getMethod(  
						"get" + getMethodName(name));
				value =  m.invoke(object);
			} catch (Exception e) {
				logger.debug("property {} has no getter method", name);
			}  
			if (excludeEmptyValue && (value == null || (value instanceof String && StringUtil.isEmpty(value.toString())))) {
				continue;
			}
			if (!map.containsKey(name)) {
				map.put(name, value);
			}
		}
		if (clazz.getSuperclass() != null && !"object".equalsIgnoreCase(clazz.getSuperclass().getSimpleName())) {
			map.putAll(getSuperClassFieldsAsMap(object, clazz.getSuperclass(), map, excludeFields, excludeEmptyValue));
		}
		return map;
	}
	
	/**
	 * 字符串首字母大写
	 * @param fildeName
	 * @return
	 * @throws Exception
	 */
    public static String getMethodName(String fildeName) {  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'a' + 'A');  
        return new String(items);  
    }  
    
    /**
     * 获取对象属性打印字符串
     * @param object
     * @param null2Empty
     * @return
     */
    public static String getFieldsAsString (Object object, boolean null2Empty) {
    	StringBuffer sb = new StringBuffer();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			sb.append("\r\n");
            // 拿到该属性的gettet方法  
            /** 
             * 这里需要说明一下：他是根据拼凑的字符来找你写的getter方法的 
             * 在Boolean值的时候是isXXX（默认使用ide生成getter的都是isXXX） 
             * 如果出现NoSuchMethod异常 就说明它找不到那个gettet方法 需要做个规范 
             */  

			String name = field.getName();
			Object value = null;
			try {
				Method m = (Method) object.getClass().getMethod(  
				        "get" + getMethodName(name));
				value =  m.invoke(object);
			} catch (Exception e) {
				logger.error("get object String error -object:{} - error message:", object, e);
			}
			if (null2Empty && value == null) {
				value = "";
			}
			if (value instanceof java.util.Date) {
				value = DateUtil.formatDate((java.util.Date)value, "yyyy-MM-dd HH:mm:ss:SSS");
			}
			sb.append("	").append(name).append(":").append(value);
        }
		return sb.toString();
    }
    
    /**
     * 获取对象属性打印字符串
     * @param object
     * @return
     */
    public static String getFieldsAsString (Object object) {
    	return getFieldsAsString(object, true);
    }
    
    /**
     * 判断字符串数组中是否包含某值
     * @param args
     * @param target
     * @return
     */
    private static boolean contains (String[] args, String target) {
    	if (args == null || args.length < 1) {
    		return false;
    	}
    	for (String str : args) {
    		if (str.equals(target)) {
    			return true;
    		}
    	}
    	return false;
    }
}
