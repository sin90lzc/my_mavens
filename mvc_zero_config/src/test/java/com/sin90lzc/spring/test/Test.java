/**
 *
 * created on 2015年8月8日 下午8:06:59
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年8月8日 下午8:06:59
 * 
 * @author Tim Leung
 */
public class Test {
 
	public static void main(String[] args) {
		try{
			throw new NullPointerException();
		}catch(RuntimeException re){
			System.out.println("abc");
		}
	}
}
