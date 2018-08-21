package com.zyxy.common.util;

public class IDCardUtil {
    /**
     * 提取身份证中的生日
     *
     * @param idCardId
     * @return
     */
    public static String getBirthday(String idCardId) {
        return idCardId.substring(6, 14);
    }
}
