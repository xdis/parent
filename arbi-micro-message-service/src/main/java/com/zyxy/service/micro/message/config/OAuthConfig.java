package com.zyxy.service.micro.message.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OAuthConfig {
	
	@Autowired
	private Weibo weibo;
	
	@Autowired
	private Qq qq;
	
	@Autowired
	private Weixin weixin;

	@Autowired
	private WeixinForYN weixinForYN;

	@Configuration
	@ConfigurationProperties(prefix = "oauth.weibo")
	public class Weibo {
		// 微博认证H5认证地址
		private String h5AuthUrl;
		// 微博获取用户token地址
		private String tokenUrl;
		// 微博获取用户信息地址
		private String showUserInfoUrl;
		// appId
		private String appId;
		// appKey
		private String appKey;
		/**
		 * 显示方式：
		 * default	默认的授权页面，适用于web浏览器。
		 * mobile	移动终端的授权页面，适用于支持html5的手机。注：使用此版授权页请用 https://open.weibo.cn/oauth2/authorize 授权接口
		 * wap	wap版授权页面，适用于非智能手机。
		 * client	客户端版本授权页面，适用于PC桌面应用。
		 * apponweibo	默认的站内应用授权页，授权后不返回access_token，只刷新站内应用父框架。
		 */
		private String display;
		public String getAppId() {
			return appId;
		}
		public void setAppId(String appId) {
			this.appId = appId;
		}
		public String getAppKey() {
			return appKey;
		}
		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}
		public String getDisplay() {
			return display;
		}
		public void setDisplay(String display) {
			this.display = display;
		}
		public String getH5AuthUrl() {
			return h5AuthUrl;
		}
		public void setH5AuthUrl(String h5AuthUrl) {
			this.h5AuthUrl = h5AuthUrl;
		}
		public String getTokenUrl() {
			return tokenUrl;
		}
		public void setTokenUrl(String tokenUrl) {
			this.tokenUrl = tokenUrl;
		}
		public String getShowUserInfoUrl() {
			return showUserInfoUrl;
		}
		public void setShowUserInfoUrl(String showUserInfoUrl) {
			this.showUserInfoUrl = showUserInfoUrl;
		}
		
		
	}
	
	@Configuration
	@ConfigurationProperties(prefix = "oauth.qq")
	public class Qq {
		// QQ认证H5认证地址
		private String h5AuthUrl;
		// QQ获取用户token地址
		private String tokenUrl;
		// QQ获取用户信息地址
		private String showUserInfoUrl;
		// appId
		private String appId;
		// appKey
		private String appKey;
		// 获取用户openid url
		private String openIdUrl;
		/**
		 * 仅PC网站接入时使用。 
		 *用于展示的样式。不传则默认展示为PC下的样式。
		 *如果传入“mobile”，则展示为mobile端下的样式。
		 */
		private String display;
		public String getAppId() {
			return appId;
		}
		public void setAppId(String appId) {
			this.appId = appId;
		}
		public String getAppKey() {
			return appKey;
		}
		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}
		public String getDisplay() {
			return display;
		}
		public void setDisplay(String display) {
			this.display = display;
		}
		public String getH5AuthUrl() {
			return h5AuthUrl;
		}
		public void setH5AuthUrl(String h5AuthUrl) {
			this.h5AuthUrl = h5AuthUrl;
		}
		public String getTokenUrl() {
			return tokenUrl;
		}
		public void setTokenUrl(String tokenUrl) {
			this.tokenUrl = tokenUrl;
		}
		public String getShowUserInfoUrl() {
			return showUserInfoUrl;
		}
		public void setShowUserInfoUrl(String showUserInfoUrl) {
			this.showUserInfoUrl = showUserInfoUrl;
		}
		public String getOpenIdUrl() {
			return openIdUrl;
		}
		public void setOpenIdUrl(String openIdUrl) {
			this.openIdUrl = openIdUrl;
		}
	}
	
	@Configuration
	@ConfigurationProperties(prefix = "oauth.weixin")
	public class Weixin {
		// QQ认证H5认证地址
		private String h5AuthUrl;
		// QQ获取用户token地址
		private String tokenUrl;
		// QQ获取用户信息地址
		private String showUserInfoUrl;
		// appId
		private String appId;
		// appKey
		private String appKey;
		// 商户号
		private String mchId;
		// 支付密钥
		private String key;
		// 统一下单地址
		private String orderUrl;
		// 查询订单地址
		private String orderQueryUrl;
		// 获取api_ticket地址
        private String ticketUrl;
        // 获取业务access_token地址
        private String coreAccessTokenUrl;

		public String getAppId() {
			return appId;
		}
		public void setAppId(String appId) {
			this.appId = appId;
		}
		public String getAppKey() {
			return appKey;
		}
		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}
		public String getH5AuthUrl() {
			return h5AuthUrl;
		}
		public void setH5AuthUrl(String h5AuthUrl) {
			this.h5AuthUrl = h5AuthUrl;
		}
		public String getTokenUrl() {
			return tokenUrl;
		}
		public void setTokenUrl(String tokenUrl) {
			this.tokenUrl = tokenUrl;
		}
		public String getShowUserInfoUrl() {
			return showUserInfoUrl;
		}
		public void setShowUserInfoUrl(String showUserInfoUrl) {
			this.showUserInfoUrl = showUserInfoUrl;
		}
		public String getMchId() {
			return mchId;
		}
		public void setMchId(String mchId) {
			this.mchId = mchId;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getOrderUrl() {
			return orderUrl;
		}
		public void setOrderUrl(String orderUrl) {
			this.orderUrl = orderUrl;
		}
		public String getOrderQueryUrl() {
			return orderQueryUrl;
		}
		public void setOrderQueryUrl(String orderQueryUrl) {
			this.orderQueryUrl = orderQueryUrl;
		}

		public String getTicketUrl() {
            return ticketUrl;
        }

        public void setTicketUrl(String ticketUrl) {
            this.ticketUrl = ticketUrl;
        }

        public String getCoreAccessTokenUrl() {
            return coreAccessTokenUrl;
        }

        public void setCoreAccessTokenUrl(String coreAccessTokenUrl) {
            this.coreAccessTokenUrl = coreAccessTokenUrl;
        }
    }

	@Configuration
	@ConfigurationProperties(prefix = "yn.weixin")
	public class WeixinForYN {
		// appId
		private String appId;
		// appKey
		private String appKey;
		// 获取api_ticket地址
		private String ticketUrl;
		// 获取业务access_token地址
		private String coreAccessTokenUrl;

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getAppKey() {
			return appKey;
		}

		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}

		public String getTicketUrl() {
			return ticketUrl;
		}

		public void setTicketUrl(String ticketUrl) {
			this.ticketUrl = ticketUrl;
		}

		public String getCoreAccessTokenUrl() {
			return coreAccessTokenUrl;
		}

		public void setCoreAccessTokenUrl(String coreAccessTokenUrl) {
			this.coreAccessTokenUrl = coreAccessTokenUrl;
		}
	}
	
	public Weibo getWeibo() {
		return weibo;
	}


	public void setWeibo(Weibo weibo) {
		this.weibo = weibo;
	}
	
	public Qq getQq() {
		return qq;
	}


	public void setQq(Qq qq) {
		this.qq = qq;
	}


	public Weixin getWeixin() {
		return weixin;
	}


	public void setWeixin(Weixin weixin) {
		this.weixin = weixin;
	}

	public WeixinForYN getWeixinForYN() {
		return weixinForYN;
	}

	public void setWeixinForYN(WeixinForYN weixinForYN) {
		this.weixinForYN = weixinForYN;
	}

	
}
