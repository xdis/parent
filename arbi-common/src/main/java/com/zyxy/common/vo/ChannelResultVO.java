package com.zyxy.common.vo;



/**
 * 渠道接口调用通用返回
 * @author tanquan
 */
public class ChannelResultVO<T> {
	
	private Boolean ok;
    
    private String message;
	
	private String channelCode;
	
	private String channelMsg;
	
	private String voucherNo;
	
	private Boolean isFree = true;
	
	private T attach;

    public Boolean getOk() {
        return ok;
    }

    public ChannelResultVO<T> setOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ChannelResultVO<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getAttach() {
        return attach;
    }

    public ChannelResultVO<T> setAttach(T attach) {
        this.attach = attach;
        return this;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelMsg() {
        return channelMsg;
    }

    public void setChannelMsg(String channelMsg) {
        this.channelMsg = channelMsg;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public ChannelResultVO<T> setIsFree(Boolean isFree) {
        this.isFree = isFree;
        return this;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }
	
}
