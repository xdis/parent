package com.zyxy.common.vo;



/**
 * 内部间接口调用通用返回
 * @author tanquan
 */
public class BuzzResultVO<T> {
	
	private Boolean ok;
	
	private String message;
	
	private T attach;

    public Boolean getOk() {
        return ok;
    }

    public BuzzResultVO<T> setOk(Boolean ok) {
        this.ok = ok;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BuzzResultVO<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getAttach() {
        return attach;
    }

    public BuzzResultVO<T> setAttach(T attach) {
        this.attach = attach;
        return this;
    }
}
