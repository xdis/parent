package com.zyxy.service.micro.third.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EBaoQuanConfig {

    @Autowired
    private HeTongBao heTongBao;

    @Autowired
    private JunZiQian junZiQian;

    @Configuration
    @ConfigurationProperties(prefix = "eBaoQuan.heTongBao")
    public class HeTongBao {
        /**
         * 合同宝服务地址
         */
        private String servicesUrl;
        /**
         * 合同宝appKey
         */
        private String appKey;
        /**
         * 合同宝appSecret
         */
        private String appSecret;

        public String getServicesUrl() {
            return servicesUrl;
        }

        public void setServicesUrl(String servicesUrl) {
            this.servicesUrl = servicesUrl;
        }

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }
    }

    @Configuration
    @ConfigurationProperties(prefix = "eBaoQuan.junZiQian")
    public class JunZiQian {
        /**
         * 君子签服务地址
         */
        private String servicesUrl;
        /**
         * 君子签appKey
         */
        private String appKey;
        /**
         * 君子签appSecret
         */
        private String appSecret;

        public String getServicesUrl() {
            return servicesUrl;
        }

        public void setServicesUrl(String servicesUrl) {
            this.servicesUrl = servicesUrl;
        }

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }
    }

    public HeTongBao getHeTongBao() {
        return heTongBao;
    }

    public void setHeTongBao(HeTongBao heTongBao) {
        this.heTongBao = heTongBao;
    }

    public JunZiQian getJunZiQian() {
        return junZiQian;
    }

    public void setJunZiQian(JunZiQian junZiQian) {
        this.junZiQian = junZiQian;
    }
}
