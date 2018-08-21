package com.zyxy.common.exception;

/**
 * 业务错误通用异常
 * @author tanquan
 *
 */
public class BuzzException extends RuntimeException {

	private static final long serialVersionUID = 5723345608979989363L;
	
	/**
     * Creates a new BuzzException.
     */
    public BuzzException() {
        super();
    }

    /**
     * Constructs a new BuzzException.
     *
     * @param message the reason for the exception
     */
    public BuzzException(String message) {
        super(message);
    }

    /**
     * Constructs a new BuzzException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public BuzzException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new BuzzException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public BuzzException(String message, Throwable cause) {
        super(message, cause);
    }
	

}
