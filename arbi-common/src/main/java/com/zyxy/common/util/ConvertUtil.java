package com.zyxy.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 转换工具类
 * Created on 2017/11/5.
 * @author xuyh
 */
public class ConvertUtil {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <O, I> O convert(I inObject, Class outObjectClass) {
        if (inObject == null) {
            throw new RuntimeException("inObject is empty!");
        }
        if (outObjectClass == null) {
            throw new RuntimeException("outObjectClass is empty!");
        }
        //映射inObject所有属性及属性值到Map对象
        Map<String, Object> inObjectMap = new HashMap<>(16);
        try {
            putFieldValueToMap(inObject, inObjectMap);
            putFieldValueToMap(inObject, inObjectMap);
        }catch (Exception e) {
            throw new RuntimeException("inObject Field is private!");
        }
        O outObject;
        try {
            outObject = (O) outObjectClass.newInstance();
        }catch (Exception e) {
            throw new RuntimeException("outObjectClass newInstance Exception!");
        }
        Object nowValue;
        try {
            Field[] outObjectClassFields = outObjectClass.getDeclaredFields();
            for (Field outObjectClassField : outObjectClassFields) {
                outObjectClassField.setAccessible(true);
                nowValue = inObjectMap.get(outObjectClassField.getName());
                if (nowValue == null) {
                    continue;
                }
                outObjectClassField.set(outObject, nowValue);
            }
        }catch (Exception e) {
            throw new RuntimeException("outObject Field is private!");
        }
        return outObject;
    }

    /**
     * 将对象Field名称及值加入Map中
     * @param inObject 对象
     * @param inObjectMap Map对象
     */
    private static void putFieldValueToMap(Object inObject, Map<String, Object> inObjectMap) {
        Field[] inObjectClassFields = inObject.getClass().getDeclaredFields();
        try{
            for (Field inObjectClassField : inObjectClassFields) {
                Object value = inObjectClassField.get(inObject);
                if (value == null) {
                    continue;
                }
                inObjectClassField.setAccessible(true);
                inObjectMap.put(inObjectClassField.getName(), inObjectClassField.get(inObject));
            }
        } catch (Exception e) {
            throw new RuntimeException("inObject Field is private!");
        }
    }
}
