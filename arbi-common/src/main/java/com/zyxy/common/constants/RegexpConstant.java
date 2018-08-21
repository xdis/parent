package com.zyxy.common.constants;

/**
 * 正则常量类
 * Created by Jin on 2017/7/21.
 */
public class RegexpConstant {

    // 手机号正则表达式
    public static final String PHONE_REGEX = "\\d{11}";
    // 银行卡号正则表达式
    public static final String BANK_CARD_REGEX = "[0-9]{13,19}";
    // 订单号正则表达式
    public static final String ORDER_ID_REGEX = "[0-9a-zA-Z]{1,32}";
    // 短信验证码正则表达式
    public static final String SMS_CODE_REGEX = "\\d{6}";
    // 18位身份证号正则表达式
    public static final String ID_CORD_REGEX = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)(?!.*[^0-9X])$";
    // 系统通用ID规则
    public static final String ID_COMMON_REGEX = "^[0-9a-zA-Z]{10,32}$";
    // 邮箱正则表达式
    public static final String MAIL_REGEX = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

    //日期
    public static final String DATE_REGEX = "(|[0-9]{4}\\-[0-9]{2}\\-[0-9]{2})";
    
    // http地址
    public static final String HTTP_URL_REGEX = "^https?://.*";


    /*
     * Form类正则规则
     */
    //当事人角色
    public static final String PARTY_CURRENT_ROLE_REGEX = "[012]";

    //案件受理参数
    public static final String ARBITRATOR_CASE_ACCEPT_REGEX = "[01]";

    //接案状态参数
    public static final String ARBITRATOR_ACCEPT_STATUS_REGEX="[01]";
    
    //案件受理参数
    public static final String CASE_ID_REGEX = ".*?";
    
    //仲裁委密码参数
    public static final String SYS_USER_REGEX ="^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$]).{8,32}$";

    //仲裁员案件状态参数
    public static final String ARBITRATOR_CASE_STATUS_REGEX="[01]";

    //文书状态参数
    public static final String DOC_STATUS_REGEX="[01]";

    //文书类型参数
    public static final String DOC_TYPE_REGEX="[01]";
    
    //文书出具类型参数
    public static final String DOC_ISSUE_TYPE="[01]";
    
    //文书内容是否为草稿参数
    public static final String DOC_IS_A_DRAFT="[01]";
    
    //回避人类型
    public static final String AVOID_TYPE_REGEX = "[01]";

    //回避方式
    public static final String AVOID_STYLE_REGEX = "[01]";
    
    //申请人代理类型参数
    public static final String PROP_LITIGANT_TYPE_REGEX="[01]";

    //被申请人代理类型参数
    public static final String DEFE_LITIGANT_TYPE_REGEX="[01]";
    
    //案件请求标志
    public static final String CASE_COUNTERCLAIM_FLAG="[01]";
    
    //案件代理标志
    public static final String CASE_ANGENT_FLAG="[01]";

    //发送方类型
    public static final String SENDER_TYPE_REGEX = "[0123]";

    /**
     * 案件类型参数
     */
    public static final String CASE_TYPE_REGEX="[1234]";
    /**
     * 案件申请类型，0代理立案，1个人立案
     */
    public static final String CASE_FILING_TYPE_REGEX="[01]";
    public static final String SEX_REGEX="[01]";
    public static final String DE_APPLICANT_TYPE_REGEX="[01]";
    //仲裁员是否系统推荐
    public static final String ARBITRATOR_IS_SYS_RECOMMEND = "[01]";
    //仲裁员选择方
    public static final String ARBITRATOR_CHOICER = "[012]";
    //仲裁员提问对象
    public static final String ARBITRATOR_QUSETION_OBJECT= "[012]";
    //申请方标志
    public static final String PROPESER_FLAG="[01]";
    /**
     * 用户类型
     */
    public static final String USER_TYPE_REGEX="[01]";
    /**
     * 企业类型
     */
    public static final String ENT_TYPE_REGEX = "[01]";

    //问题回答状态
    public static final String QUESTION_ANSWER_STATUS="[01]";

    //和解调节消息发送方
    public static final String COMPROMISE_RECORD_SEND_TYPE="[012]";
    
    //和解调节类型
    public static final String COMPROMISE_RECORD_MESSAGE_TYPE="[01]";
    
    //发送消息类型
    public static final String SYS_MESSAGE_RECEIVE_TYPE="[01234]";
    
    //证据来源类型
    public static final String CASE_EVIDENCE_TYPE="[01]";
    
    //当事人和解回应方类型
    public static final String COMPROMISE_RESPONSE_TYPE="[01]";
    
    //和解方式
    public static final String COMPROMISE_RESPONSE_STYLE = "[01]";
    
    //和解回应状态
    public static final String COMPROMISE_RESPONSE_STATUS ="[01]";

    //文书状态参数
    public static final String OPINIONS_OF_ARBITRATOR_REGEX = "[01]";
    
    private RegexpConstant() {
    }
}
