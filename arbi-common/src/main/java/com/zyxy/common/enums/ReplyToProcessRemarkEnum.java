package com.zyxy.common.enums;

/**
 * 答辩期到审理期原因枚举类
 *
 * @author jax
 */
public enum ReplyToProcessRemarkEnum {

    /**
     * 本请求答辩期结束,进入审理期
     */
    CASE_REPLY_OVER("本请求答辩期结束,进入审理期"),
    /**
     * 和解终止,进入审理期
     */
    CASE_COMPROMISE_TERMINATION("和解终止,进入审理期");

    private String remark;

    ReplyToProcessRemarkEnum(String remark) {
        this.remark = remark;
    }

    public static ReplyToProcessRemarkEnum getByValue(String userTypeStr) {
        for (ReplyToProcessRemarkEnum o : ReplyToProcessRemarkEnum.values()) {
            if (o.toString().equals(userTypeStr)) {
                return o;
            }
        }
        return null;
    }

    public String getRemark() {
        return remark;
    }
}
