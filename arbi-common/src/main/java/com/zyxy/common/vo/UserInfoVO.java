package com.zyxy.common.vo;

/**
 * 用户基本信息VO
 */
public class UserInfoVO {
	
	/**
     * 姓名
     */
    private String name;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 职务
     */
    private String duties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}
    
}
