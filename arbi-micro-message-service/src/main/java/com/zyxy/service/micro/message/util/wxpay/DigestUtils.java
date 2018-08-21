package com.zyxy.service.micro.message.util.wxpay;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public class DigestUtils {

    /**
     * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     */
    public static String createSign(String characterEncoding, SortedMap<String, String> paraMap, String weiXinKey) {
        StringBuilder sb = new StringBuilder();
        Set<Entry<String, String>> es = paraMap.entrySet();//所有参与传参的参数按照accsii排序（升序）  
        Iterator<Entry<String, String>> it = es.iterator();
        while (it.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=").append(weiXinKey);
        return MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
    }

}
