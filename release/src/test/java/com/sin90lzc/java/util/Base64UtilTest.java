/**
 *
 * created on 2015年5月17日 上午11:49:28
 * 
 * @author Tim Leung
 */
package com.sin90lzc.java.util;

import junit.framework.Assert;

import org.junit.Test;

import sun.misc.*;
/**
 * copyright 
 * all right reserved.
 * 
 * created on 2015年5月17日 上午11:49:28
 * 
 * @author Tim Leung
 */
public class Base64UtilTest {

	private static final transient String DECODE_STRING="hello world";
	
	@Test
	public void testDecode() throws Exception{
		byte[] bytes = DECODE_STRING.getBytes();
		BASE64Encoder base64Encoder = new BASE64Encoder();
		base64Encoder.encode(bytes);
		System.out.println(base64Encoder.encode(bytes));
		Assert.assertEquals(base64Encoder.encode(bytes), Base64Util.encode(bytes, 0, bytes.length));
		
	}
	
}
