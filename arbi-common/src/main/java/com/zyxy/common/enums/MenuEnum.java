package com.zyxy.common.enums;

public enum MenuEnum {



    /**
    *仲裁申请
    *
    * */
    ARBITRATION_APPLICATIO("0","仲裁申请"),

    /**
     *
     * 选择仲裁员
     * */
    SELECT_AN_ARBITRATOR("1","选择仲裁员"),

    /**
     *
     * 举证
     * */
    QUOTE("2","举证"),

    /***
     *申请撤案
     */
    WITHDRAW_CASE("11","本请求申请撤案"),

    /**
     * 变更仲裁请求
     */
    CHANGE_OF_ARBITRATION_REQUEST("12","变更仲裁请求"),


    /**
     * 申请秘书回避
     */
    APPLY_FOR_SECRETARIAL_AVOIDANCE("13","申请秘书回避"),


    /**
     * 反请求管辖权异议
     */
    OBJECTION_JURISDICTION_THE_COUNTERCLAIM("14","反请求管辖权异议"),

    /**
     * 申请延期举证
     */
    APPLY_FOR_EXTENSION_PROOF("15","申请延期举证"),

    /**
     * 反请求
     */
    COUNTER_REQUEST("16","反请求申请"),

    /**
     * 本请求管辖权异议
     */
    JURISDICTION_OBJECTION("17","管辖权异议"),


    /**
     * 反请求变更
     */
    REVERSE_REQUEST_CHANGE("18","反请求变更"),



    /**
     * 仲裁员回避
     */
    ARBITRATOR_AVOIDANCE("19","仲裁员回避"),

    /**
     * 反请求申请撤案
     */
    REVERSE_WITHDRAW_CASE("27","反请求申请撤案"),

    /****************和解按钮**********************/
    /**
     * 和解申请
     */
    COMPROMISE_APPLY("20","和解申请"),
    
    /**
     * 和解同意
     */
    COMPROMISE_AGREE("21","和解同意"),
    
    /**
     *和解拒绝     
     */
    COMPROMISE_REFUSE("22","和解拒绝 "),
    /**
     * 调节协议书申请
     */
    COMPROMISE_PROTOCOL_APPLY("23","调节协议书申请"),

    /**
     * 调节协议书同意
     */
    COMPROMISE_PROTOCOL_AGREE("24","调节协议书同意"),
    
    /**
     * 调节协议书拒绝
     */
    COMPROMISE_PROTOCOL_REFUSE("25","调节协议书拒绝"),
    
    /**
     * 裁决书申请
     */
   COMPROMISE_DECISION_APPLY("26","裁决书申请"),
  
    ;






    private String code;

    private String remark;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    MenuEnum(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public static MenuEnum getCode(String code) {
        for (MenuEnum c : MenuEnum.values()) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }


}
