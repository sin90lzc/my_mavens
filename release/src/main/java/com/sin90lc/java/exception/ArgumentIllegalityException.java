/**
 * 
 */
package com.sin90lc.java.exception;

/**
 *
 * @author liangzhicong
 * 
 * create at 2015年4月23日 下午1:22:13
 */
public class ArgumentIllegalityException extends Exception {

	/**
	 * 
	 * @category 
	 * 
	 *
	 * @author liangzhicong
	 */
	public ArgumentIllegalityException() {
		super();
	}

	/**
	 * 
	 * @category 
	 * 
	 *
	 * @author liangzhicong
	 */
	public ArgumentIllegalityException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * 
	 * @category 
	 * 
	 *
	 * @author liangzhicong
	 */
	public ArgumentIllegalityException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @category 
	 * 
	 *
	 * @author liangzhicong
	 */
	public ArgumentIllegalityException(String message) {
		super(message);
	}

	/**
	 * 
	 * @category 
	 * 
	 *
	 * @author liangzhicong
	 */
	public ArgumentIllegalityException(Throwable cause) {
		super(cause);
	}

	
	
	
}
