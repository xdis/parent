package com.zyxy.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * AES加密解密
 * @author tanquan
 *
 */
public class AESUtil {
	private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
	
	
    /**
     * AES（256）位加密
     * @param content 	需要加密的内容
     * @param password  加密密码
     * @return 			返回二进制数组
     */
    public static byte[] encrypt(String content, String password) {
        try {
        	//获得一个密钥
        	byte[] enCodeFormat = generatorKey(password);
            
            //根据给定的字节数组（enCodeFormat）构造一个密钥。
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            
            // 创建密码器 
            //其中参数也可以为//算法/模式/填充（DES/CFB8/NoPadding）
            Cipher cipher = Cipher.getInstance("AES");
            
            byte[] byteContent = content.getBytes("utf-8");
            //初始化
            //初始化有四种操作加密、解密、密钥包装或密钥解包，分别对应（ENCRYPT_MODE、DECRYPT_MODE、WRAP_MODE 或 UNWRAP_MODE）
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            return result; 
        } catch (NoSuchAlgorithmException e) {
        	logger.error("aes encrypt error -content:{} - error message:", content, e);
        } catch (NoSuchPaddingException e) {
        	logger.error("aes encrypt error -content:{} - error message:", content, e);
        } catch (InvalidKeyException e) {
        	logger.error("aes encrypt error -content:{} - error message:", content, e);
        } catch (UnsupportedEncodingException e) {
        	logger.error("aes encrypt error -content:{} - error message:", content, e);
        } catch (IllegalBlockSizeException e) {
        	logger.error("aes encrypt error -content:{} - error message:", content, e);
        } catch (BadPaddingException e) {
        	logger.error("aes encrypt error -content:{} - error message:", content, e);
        }
        return null;
    }

    /**
     * 加密(这种加密方式有两种限制)
     * 1.密钥必须是16位的
     * 2.待加密内容的长度必须是16的倍数，如果不是16的倍数，就会出如下异常：javax.crypto.IllegalBlockSizeException: Input length not multiple of 16 bytes
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt2(String content, String password) {
        try {
            SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
        	logger.error("encrypt error -content:{} - error message:", content, e);
        } catch (NoSuchPaddingException e) {
        	logger.error("encrypt error -content:{} - error message:", content, e);
        } catch (InvalidKeyException e) {
        	logger.error("encrypt error -content:{} - error message:", content, e);
        } catch (UnsupportedEncodingException e) {
        	logger.error("encrypt error -content:{} - error message:", content, e);
        } catch (IllegalBlockSizeException e) {
        	logger.error("encrypt error -content:{} - error message:", content, e);
        } catch (BadPaddingException e) {
        	logger.error("encrypt error -content:{} - error message:", content, e);
        }
        return null;
    }

    /**
     * AES（256）解密
     * @param content  待解密内容
     * @param password 解密密钥
     * @return 解密之后
     * @throws Exception 
     */
    public static byte[] decrypt(byte[] content, String password) throws Exception {
        try {
        	//获得一个密钥
        	byte[] enCodeFormat = generatorKey(password);
            
            //根据给定的字节数组（enCodeFormat）构造一个密钥。
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            
            // 初始化解码器
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            
            return result;
        } catch (Exception e) {
            throw new Exception("解密失败！");
        } 
    }

    /**
     * 获得一个AES 32位密钥
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] generatorKey(String password) throws NoSuchAlgorithmException{
    	 KeyGenerator kgen = KeyGenerator.getInstance("AES");
         //随即初始化一个256（128、192）为的密码生成器
    	 SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
    	 secureRandom.setSeed(password.getBytes()); 
         kgen.init(256, secureRandom);
         //生成一个密钥
         SecretKey secretKey = kgen.generateKey();
         //获得一个密钥
         byte[] enCodeFormat = secretKey.getEncoded();
         return enCodeFormat;
    }
    
    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
