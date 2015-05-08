/**
 *
 * created on 2015年4月12日 下午4:15:40
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.mock.jndi;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年4月12日 下午4:15:40
 * 
 * @author Tim Leung
 */
public class TestUseMockJNDI {
	
	@Before
	public void setupJNDI(){
		 SimpleNamingContextBuilder builder;
		try {
			builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
			builder.bind("java:comp/env/jdbc/abc", "hello world");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		 
	}
	@Test
	public void testMockJNDI(){
		try {
			InitialContext context=new InitialContext();
			Object abc=context.lookup("java:comp/env/jdbc/abc");
			Assert.assertEquals("hello world", abc);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
}
