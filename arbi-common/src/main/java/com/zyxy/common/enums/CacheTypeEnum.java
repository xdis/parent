package com.zyxy.common.enums;


/**
 * 系统缓存类型定义
 * @author tanquan
 *
 */
public enum CacheTypeEnum{
	
	DATADIC("datadic", "字典表缓存名称", "通用", 60L * 60 * 24),
	MENU("menu", "菜单权限缓存", "后台管理系统", 60L * 60 * 24),
	TELE_MESSAGE_GAIN_TIMES("tele_message_gain_times", "手机短信获取最大次数限制", "通用", 60L * 60 * 24),
	PWD_FAILED_TIMES("pwd_failed_times", "密码错误次数缓存", "后台管理系统", 60L * 60 * 24),
	WX_ACCESS_TOKEN("wx_access_token", "微信access_token缓存", "用户端", 60L * 60 * 24),
	WX_TICKET("wx_ticket", "微信ticket缓存", "用户端", 60L * 60 * 24),
	USER_FILE("user_file", "用户文件信息缓存", "通用", 60L * 60 * 24),
	RL_PAY_LOGIN_KEY("rl_pay_login_key", "瑞联支付登录KEY", "支付服务", 60L * 60 * 24),
	ORG_CERT("org_cert", "用户/机构证书缓存", "API服务", 60L * 60 * 24),
	ORG_INFO("org_info", "用户/机构信息缓存", "API服务", 60L * 60 * 24),
	API_SSO_TOKEN("api_sso_token", "API单点登录token缓存", "API服务", 30L),
	APPROVE_TYPE("approveType","审批类型","通用",60L * 60 * 24);
	
	private String code;
	
	private String memo;
	
	private String owner;
	
	/**
	 * 缓存过期时间（单位：秒）
	 */
	private Long expire;

	private CacheTypeEnum (String code, String memo, String owner, Long expire) {
		this.code = code;
		this.memo = memo;
		this.owner = owner;
		this.expire = expire;
	}
	
	public Long getExpire() {
        return expire;
    }



    public void setExpire(Long expire) {
        this.expire = expire;
    }



    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public static CacheTypeEnum getCode(String code) {
		for (CacheTypeEnum c : CacheTypeEnum.values()) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}
}
