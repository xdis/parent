package com.zyxy.common.enums;

import com.zyxy.common.util.ArrayUtil;

public class SysEnum {
	/**
	 * 文件业务类型
	 * @author tanquan
	 *
	 */
	public static enum FileBuzzType {
		HEAD_PHOTO("S_0001", new String[]{"jpg", "png", "gif"}, 1024 * 1024, "用户头像", "用户系统"),
		CASE_EVIDENCE("C_0001", new String[]{"jpg", "png", "gif", "pdf", "zip", "rar", "7z"}, 1024 * 1024 * 100, "证据材料", "用户系统"),
		CASE_DOC("C_0002", new String[]{"jpg", "png", "gif", "pdf", "zip", "rar", "7z"}, 1024 * 1024 * 50, "文书", "用户系统"),
		USER_CERTIFICATION_IMG("S_0022", new String[]{"jpg", "png", "gif"}, 1024 * 1024 * 5, "用户证件照", "用户系统");
		private String code;
		private String[] allowExts;
		private long allowSize;
		private String descr;
		private String belong;
		private FileBuzzType (String code, String[] allowExts, long allowSize, String desc, String belong) {
			this.setCode(code);
			this.setDescr(desc);
			this.setBelong(belong);
			this.setAllowExts(allowExts);
			this.setAllowSize(allowSize);
		}
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
		public String getBelong() {
			return belong;
		}
		public void setBelong(String belong) {
			this.belong = belong;
		}
		
		public String[] getAllowExts() {
			return allowExts;
		}

		public void setAllowExts(String[] allowExts) {
			this.allowExts = allowExts;
		}

		public long getAllowSize() {
			return allowSize;
		}

		public void setAllowSize(long allowSize) {
			this.allowSize = allowSize;
		}
		
		/**
		 * 根据业务代码获取业务类型对象
		 * @param code
		 * @return
		 */
		public static FileBuzzType getTypeByCode(String code) {
			for(FileBuzzType bt : FileBuzzType.values()) {
				if (bt.getCode().equals(code)) {
					return bt;
				}
			}
			return null;
		}
		
		public static  String getBusiTypeStr() {
			StringBuffer sb = new StringBuffer();
			sb.append("[").append("\n");
			int i = 0;
			for (FileBuzzType bt : FileBuzzType.values()) {
				if (i != 0) {
					sb.append(",\n");
				}
				sb.append("{code : ").append(bt.getCode())
				.append(", descr : ").append(bt.getDescr())
				.append(", allowExts : ").append(ArrayUtil.join(bt.getAllowExts(), ","))
				.append(", allowSize : ").append(bt.getAllowSize())
				.append("}");
				i++;
			}
			sb.append("\n").append("]");
			return sb.toString();
		}
	}
	
	/**
	 * yyl修改，添加注册，添加短信模版
	 * 文件业务类型
	 * @author tanquan
	 *
	 */
	public static enum SmsType {

		LOGIN(0, "登录", "SMS_95510042"),
		AMEND(1,"添加手机号", "SMS_96430043"),
		EDIT_USER_NAME(2, "修改用户登录手机号", "SMS_96535014"),
		ADD_BANK_CARD(3, "添加银行卡手机号验证", "SMS_96135016"),
		REGISTER(4, "注册", "SMS_95390040");
		private Integer code;
		private String descr;
		private String templateCode;
		private SmsType (Integer code, String descr, String templateCode) {
			this.setCode(code);
			this.setDescr(descr);
			this.setTemplateCode(templateCode);
		}
		
		/**
		 * 根据业务代码获取业务类型对象
		 * @param code
		 * @return
		 */
		public static SmsType getTypeByCode(Integer code) {
			for(SmsType bt : SmsType.values()) {
				if (bt.getCode().equals(code)) {
					return bt;
				}
			}
			return null;
		}
		
		public static  String getTypeStr() {
			StringBuffer sb = new StringBuffer();
			sb.append("[").append("\n");
			int i = 0;
			for (SmsType bt : SmsType.values()) {
				if (i != 0) {
					sb.append(",\n");
				}
				sb.append("{code : ").append(bt.getCode())
				.append(", descr : ").append(bt.getDescr())
				.append("}");
				i++;
			}
			sb.append("\n").append("]");
			return sb.toString();
		}



		public Integer getCode() {
			return code;
		}



		public void setCode(Integer code) {
			this.code = code;
		}



		public String getDescr() {
			return descr;
		}



		public void setDescr(String descr) {
			this.descr = descr;
		}

		public String getTemplateCode() {
			return templateCode;
		}
		public void setTemplateCode(String templateCode) {
			this.templateCode = templateCode;
		}
	}
	
	
	
}
