package com.zyxy.common.vo;

import java.io.Serializable;

import net.sf.ehcache.search.expression.Not;

import com.zyxy.common.exception.BuzzException;
import com.zyxy.common.util.JsonUtil;


/**
 * api、ajax 通用返回结果定义
 * @author tanquan
 *
 * @param <T> 返回的业务结果类型
 */
public class ApiResultVO<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 返回业务代码
	 */
	private Head head;
	
	/**
	 * 返回内容
	 */
	private T body;
	
	/**
	 * 返回权限信息
	 */
	private Auth auth;
	
	public ApiResultVO<T> setBody(T body) {
		this.body = body;
		return this;
	}
	
	public T getBody() {
		return this.body;
	}
	
	public ApiResultVO<T> setCoder(Coder coder) {
		if(this.head == null) {
			this.head = new Head();
		}
		this.head.setRetCode(coder.code);
		this.head.setMsg(coder.message);
		return this;
	}
	
	public ApiResultVO<T> setMessage(String message) {
		if (this.head == null) {
			throw new BuzzException("you should init header first, befour you use it");
		}
		this.head.setMsg(message);
		return this;
	}
	
	public Head getHead() {
		return this.head;
	}
	
	public void setHead(Head head) {
	    this.head = head;
	}
	
	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}
	
	/**
	 * header 默认为 Coder.ILLEGAL
	 */
	public ApiResultVO() {
		this.head = new Head();
		// 默认为非法操作
		this.head.setRetCode(Coder.ILLEGAL.getCode());
		this.head.setMsg(Coder.ILLEGAL.getMessage());
		this.auth = new Auth();
	}
	
	/**
	 * header 默认为 Coder.ILLEGAL
	 * @param auth 权限信息
	 */
	public ApiResultVO(Auth auth) {
		this.head = new Head();
		// 默认为非法操作
		this.head.setRetCode(Coder.ILLEGAL.getCode());
		this.head.setMsg(Coder.ILLEGAL.getMessage());
		this.auth = auth;
	}
	
	/**
	 * 
	 * @param coder 返回码
	 * @param auth 权限信息
	 */
	public ApiResultVO(Coder coder, Auth auth) {
		this.head = new Head();
		// 默认为非法操作
		this.head.setRetCode(coder.getCode());
		this.head.setMsg(coder.getMessage());
		this.auth = auth;
	}

	/**
	 *
	 * @param code 返回码
	 * @param message 返回信息
	 * @param auth 权限信息
	 */
	public ApiResultVO(String code, String message, Auth auth) {
		this.head = new Head();
		// 默认为非法操作
		this.head.setRetCode(code);
		this.head.setMsg(message);
		this.auth = auth;
	}

	public static enum Coder {
		SUCCESS("0000", "成功"),
		NEED_BANDING("1000", "需要登录/注册绑定三方登录帐号"),
		LOGIN_ERROR("1999", "登录错误"),
        ALREADY_EXIST("2000", "记录已存在"),
		DB_INSERT_ERROR("2001", "写入数据失败"),
		DB_UPDATE_ERROR("2002", "更新数据失败"),
		DB_DELETE_ERROR("2003", "删除数据失败"),
		DB_NOTFOUND_ERROR("2004", "未查询到相关数据"),
		ACCOUNT_ERROR("6001", "账户异常"),
		NO_LOGIN("9000", "未登录或登录超时"),
		NO_PERMISSION("9001", "无此权限"),
		AUTH_FAIL("9002", "认证失败"),
		OP_TOO_OFTEN("9003", "操作频繁"),
		VC_ERROR("9004", "验证码错误"),
        SYSTEM_BUSY("9989", "系统繁忙,请稍后再试"),
        NOT_FOUND("9990", "数据不存在"),
		CALL_THIRD_SERV_ERROR("9991", "调用三方接口错误"),
		CALL_SERV_ERROR("9991", "调用接口错误"),
		VALID_ERROR("9995", "非法的参数"),
		REQ_ERROR("9996", "非法的请求"),
		DBERROR("9997", "数据库操作失败"),
		ILLEGAL("9998", "非法操作"),
		ERROR("9999", "系统错误"),
		CONVERT_ERROR("9994","转换错误"),
		//#######################4XXX业务验证错误##########################
		CASE_NOT_IN_WAIT_ACCEPT_STATUS_ERROR("4001", "案件不在待受理状态"),
		CASE_TYPE_AND_USER_TYPE_NOT_MATCH_STATUS_ERROR("4002", "案件类型与用户类型不一致"),
		CASE_NOT_EXIST("4003","案件不存在"),
		ARBITRATOR_NOT_EXIST("4004","仲裁员不存在"),
		CASE_ALREADY_HAS_ARBITRATOR("4005","已经选择仲裁员"),
		PHONE_VERIFT_CODE_ERROR("4006","验证码错误"),
		PHONE_VERIFT_CODE_EXIST("4007","三分钟内只能发送一条短信"),
		CASE_ALREADY_HAS_BACK_REQUEST("4008","案件已经存在反请求"),
		CASE_NOT_OK_ARBITRATOR("4009","案件不存在有效的仲裁员"),
		ARBITRATOR_NOT_MATCH_ARBITRATOR_FOR_CASE("4010","当前仲裁员不是案件有效仲裁员"),
		CURRENT_ARBITRATOR_ALREADY_QUESTION("4011","当前仲裁员已经提问"),
		CASE_ALREADY_ADJUDICATION("4012","案件已经出裁决书不能撤案"),
		CASE_NOTADJUDICATION("4013","案件未裁决不能补正"),
		CASE_NOT_IN_CHECK_NODE_ERROR("4014","案件不在待审核状态中"),
		CASE_ALREADY_HAS_COMPROMISE("4015","案件已经申请和解"),
		LITIGANT_OPINION_NOT_THE_SAME("4016","双方当事人和解意见不统一"),
		ARBITRATOR_CAN_NOT_ARGUE("4017","当前时刻仲裁员不能发言"),
		REJOIN_RECORD_NOT_MATCH_CASE("4018","答辩记录不匹配案件"),
		CASE_NOT_IN_PAY_NODE_ERROR("4019","案件不在待缴费状态中"),
		EVIDENCE_NOT_MATCH_CASE("4020","证据不匹配案件"),
		USERID_NO_PRIVILEGE("4021","当前操作人无权限"),
		OLD_PASS_WORD_ERROR("4022", "原密码错误"),
        CASE_NOT_IN_REPLY_NODE_ERROR("4023", "案件不在答辩期"),
        LOST_PWD_IMG_CODE_ERROR("4024", "图像验证码错误"),
        FACE_PLUS_BEYOND_ERROR("4025", "超出验证次数，请上传手持身份证认证"),
        LABOUR_REAL_NAME_AUDITING("4027", "手持身份证审核中"),
        NOT_FACE_PLUS_ERROR("4028", "活体认证失败后才能进行人工实名审核"),
        APPROVE_NOT_IN_CHECK_NODE_ERROR("4029","该审批不在待审核状态"),
        APPROVE_TYPE_ERROR("4030", "该审批不存在或该审批不可用"),
        CARD_ID_EXIST("4031", "该身份证已经被认证"),
        REQUEST_NOT_IN_REPLY_ERROR("4032", "该请求不在答辩期"),
        REQUEST_DEALY_EXIST_ERROR("4033", "该请求已经申请过延期答辩"),
		START_DATE_SELECTION_EXIST_ERROR("4034", "和解开始时间不能超过审限期或者和审限期在同一天"),
		ENT_INFO_EXIST("4035", "认证信息审核中"),
		ENT_INFO_SUCCESS("4036", "认证已经通过"),
		CHANGE_INFO_APPING("4037", "修改申请审核中，请勿重复提交"),
		NOT_FOUND_AGENT_USER("4038","被委托方不是平台注册认证用户"),
		NOT_AUTHOR_USER("4039","代理没有进行四要素认证"),
		COMPROMIST_INFO_REVIEWED("4040","和解申请以及审核过，请勿重复提交"),
		THE_SAME_AUTHOR("4041","更改的权限和已有权限一样，请重新选择"),
		CASE_NOT_OK_SERETARY("4042","该案件无有效的仲裁秘书"),
		LITIGANT_INFO_NOT_MACTH_CASE("4043","当事人信息不匹配案件"),
		NO_PERMISSION_TO_VIEW_THIS_CASE("4044","无权限查看此案件"),
        ADJUST_CONTENT_NOT_NULL("4045", "补正内容不能为空"),
        OPINION_NOT_NULL("4046", "意见不能为空"),
        NO_PERMISSION_TO_DEAL_THIS_CASE("4047","无权限操作此案件"),
        CASE_NOT_OK_STAFF("4048","该案件无有效的仲裁委工作人员"),
        YOU_HAVE_DELEGATER_AUTHORIT("4049","你已授权给别人，无法操作此审批"),
        ;

		private String code;
        private String message;
		private Coder(String code, String message) {
			this.code = code;
			this.message = message;
		}
		
		public String getCode() {
			return code;
		}
		public Coder setCode(String code) {
			this.code = code;
			return this;
		}
		public String getMessage() {
			return message;
		}
		public Coder setMessage(String message) {
			this.message = message;
			return this;
		}
		
		public static  String getCoderStr() {
			StringBuffer sb = new StringBuffer();
			sb.append("[").append("\n");
			int i = 0;
			for (Coder coder : Coder.values()) {
				if (i != 0) {
					sb.append(",\n");
				}
				sb.append("{code : ").append(coder.getCode()).append(", msg : ").append(coder.getMessage()).append("}");
				i++;
			}
			sb.append("\n").append("]");
			return sb.toString();
		}
	}
	
	/**
	 * api请求 业务返回的返回码封装
	 * @author tanquan
	 *
	 */
	public static class Head implements Serializable{
		private static final long serialVersionUID = 1L;

		/**
		 * 返回码 参考Coder
		 */
		private String retCode;
		
		/**
		 * 返回消息 参考Coder
		 */
		private String msg;
		
		public String getRetCode() {
			return retCode;
		}
		public void setRetCode(String retCode) {
			this.retCode = retCode;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		
	}
	
	/**
	 * api请求 业务返回的权限信息
	 * @author tanquan
	 *
	 */
	public static class Auth implements Serializable{
		private static final long serialVersionUID = 1L;
		private String token;
		
		private Boolean timeout;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Boolean getTimeout() {
			return timeout;
		}

		public void setTimeout(Boolean timeout) {
			this.timeout = timeout;
		}
		
	}
	
	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
