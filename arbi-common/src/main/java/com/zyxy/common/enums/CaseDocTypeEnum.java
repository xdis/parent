package com.zyxy.common.enums;

/**
 * 案件文书类型enum
 */
public enum CaseDocTypeEnum {

    /**
     * 撤案决定书
     */
    CANCEL_DECIDE_BOOK("0","撤案决定书"),

    /**
     * 裁决书
     */
    ARBITRAL_AWARD_BOOK("1","裁决书"),

    /**
     * 仲裁申请书
     */
    APPLICATION_ARBITRATION_BOOK("2","仲裁申请书"),

    /**
     * 反请求申请书
     */
    DE_REQUEST_APPLICATION_ARBITRATION_BOOK("3","反请求申请书"),

    /**
     * 反请求撤案决定书
     */
    DE_REQUEST_CANCEL_DECIDE_BOOK("4","反请求撤案决定书"),

    /**
     * 仲裁员回避申请书
     */
    ARBITRATOR_AVOID_APPLY("5","仲裁员回避申请书"),

    /**
     * 仲裁员回避决定书
     */
    ARBITRATOR_AVOID_DECISION("6","仲裁员回避决定书"),

    /**
     * 组庭通知书
     */
    TRIBUNAL_NOTICE("7","组庭通知书"),

    /**
     * 撤回仲裁申请书
     */
    CANCEL_APPLY_BOOK("8","撤回仲裁申请书"),
    
    /**
     * 撤回反请求申请书
     */
    CANCEL_BECK_REQUEST_APPLY_BOOK("9","撤回反请求申请书"),
    
    /**
     * 变更仲裁请求申请书
     */
    CHANGE_REQUEST_APPLY_BOOK("10","变更仲裁请求申请书"),
    
    /**
     * 变更反请求申请书
     */
    CHANGE_BACK_REQUEST_APPLY_BOOK("11","变更反请求申请书"),
    
    /**
     * 调解协议申请书
     */
    COMPROMISE_PROTOCOL_APPLY_BOOK("12","调解协议申请书"),
    
    /**
     * 反请求答辩书
     */
    BACK_REQUEST_REJOIN_BOOK("13","反请求答辩书"),
    
    /**
     * 仲裁答辩书
     */
    REQUEST_REJOIN_BOOK("14","仲裁答辩书"),
    
    /**
     * 秘书回避申请书
     */
    SECRETARY_AVOID_APPLY_BOOK("15","秘书回避申请书"),
    
    /**
     * 补正申请书
     */
    ADJUDICATION_AMENDMENT_APPLY_BOOK("16","补正申请书"),
    
    /**
     * 管辖权异议申请书
     */
    REQUSTE_JUDIS_DIS_APPLY_BOOK("17","管辖权异议申请书"),
    
    /**
     * 反请求管辖权异议申请书
     */
    BACK_REQUSTE_JUDIS_DIS_APPLY_BOOK("18","反请求管辖权异议申请书"),
    
    /**
     * 本请求管辖权异议决定书
     */
    REQUSTE_JUDIS_DIS_DECISION_BOOK("19","本请求管辖权异议决定书"),
    
    /**
     * 秘书回避决定书
     */
    SECRETARIES_AVOID_DECISION_BOOK("20","秘书回避决定书"),
    
    /**
     * 反请求答辩书
     */
    BACK_CHANGE_REQUEST_REJOIN_BOOK("21","变更反请求答辩书"),
    
    /**
     * 仲裁答辩书
     */
    CHANGE_REQUEST_REJOIN_BOOK("22","变更仲裁答辩书"),

    /**
     * 反请求管辖权异议决定书
     */
    BACK_REQUSTE_JUDIS_DIS_DECISION_BOOK("23","反请求管辖权异议决定书"),

    /**
     * 不受理变更仲裁请求通知书
     */
    NOT_ACCEPT_CHANGE_OF_ARBITRATION_REQUEST_NOTICE("23","不受理变更仲裁请求通知书"),

    /**
     * 变更仲裁请求受理通知书
     */
    ACCEPT_CHANGE_OF_ARBITRATION_REQUEST_NOTICE("24","变更仲裁请求受理通知书"),

    ;

    private String code;
    
    private String docName;

    private CaseDocTypeEnum(String code,String docName) {
        this.code = code;
        this.docName = docName;
    }

    public String getCode() {
        return code;
    }

	public String getDocName() {
		return docName;
	}
}
