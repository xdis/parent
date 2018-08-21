package com.zyxy.common.enums;

/**
 * 仲裁委类型Enum
 */
public enum ManagerInfoTypeEnum {

    /**仲裁委类型**/

    /**
     * 0-立案秘书
     *
     */
	INITIATE_THE_SECRETARY("0","立案秘书"),

    /**
     * 1-立案部长
     */
	INITIATE_THE_MINISTER("1","立案部长"),

    /**
     * 2-仲裁秘书
     */
	ARBITRATION_SECRETARY("2","仲裁秘书"),

    /**
     * 3-仲裁部长
     */
	ARBITRATION_MINISTER("3","仲裁部长"),

    /**
     * 4-主任
     */
	DIRECTOR("4","主任"),
    
    /**
     * 5-副主任
     */
	DEPUTY_DIRECTOR("5","副主任");

    /**
     *
     */
     

    private String code;
    private String mark;

    private ManagerInfoTypeEnum(String code,String mark) {
        this.code = code;
        this.mark = mark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public static ManagerInfoTypeEnum getCode(String code) {
        for (ManagerInfoTypeEnum c : ManagerInfoTypeEnum.values()) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }
}
