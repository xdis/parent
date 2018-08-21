package com.zyxy.common.exception;

/**
 * 业务错误通用异常
 * @author tanquan
 *
 */
public class SmsException extends BuzzException {

	private static final long serialVersionUID = 5723345608979989363L;
	
	/**
     * Creates a new SmsException.
     */
    public SmsException() {
        super();
    }

    /**
     * Constructs a new SmsException.
     *
     * @param message the reason for the exception
     */
    public SmsException(String message) {
        super(message);
    }

    /**
     * Constructs a new SmsException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public SmsException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new SmsException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public SmsException(String message, Throwable cause) {
        super(message, cause);
    }
	

}
