/**
 * 
 */
package com.sin90lc.java.exception;

/**
 * copyright PPMoney
 * 
 *
 * @author liangzhicong
 * 
 * create at 2015��4��23�� ����1:22:13
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
	
	public ArgumentIllegalityException(String msg){
		super(msg);
	}
	
	public ArgumentIllegalityException(Throwable e){
		super(e);
	}
	
	
	
}
