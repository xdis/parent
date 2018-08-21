package com.zyxy.common.util;

public class RandomUtil {

    /**
     * 生成随机验证码
     *
     * @param len 验证码长度
     * @return
     */

    public static String createRandomVcode(int len) {
        String vcode = "";
        for (int i = 0; i < len; i++) {
            vcode = vcode + (int) (Math.random() * 9);
        }
        return vcode;
    }
}
