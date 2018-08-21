package com.zyxy.common.dto;

import com.zyxy.common.util.SHAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;

/**
 * FaceIdNotify对象
 */
public class FaceIdNotifyDTO {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 数据段签名
     */
    private String sign;

    /**
     * 网页端活体检测及比对返回值
     */
    private String data;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FaceIdNotifyDTO{" +
                "sign='" + sign + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public boolean verify (String apiSecret) {
        try {
            String encrypt = SHAUtil.encrypt(apiSecret + data, "SHA-1");
            return encrypt != null && encrypt.toLowerCase().equals(sign);
        } catch (Exception e) {
            log.error("验证失败", e);
        }
        return false;
    }
}
