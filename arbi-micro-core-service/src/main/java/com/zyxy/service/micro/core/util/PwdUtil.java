package com.zyxy.service.micro.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码相关工具
 * @author tanquan
 */
public class PwdUtil {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
	 * 密码加密方法
	 * @param data  密码明文
	 * @return		密码摘要
	 */
    public static String getPwd(String data) {
        return encoder.encode(data);
    }

    public static String getPwdEmailCode(){
		 int pwdEmailCode = (int)(Math.random()*1000000);
		 return ""+pwdEmailCode;
	 }
    
}
