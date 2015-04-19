/**
 *
 * created on 2015ï¿½ï¿½4ï¿½ï¿½19ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½3:01:21
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * ÊµÏÖTestExecutionListener£¬Ö»ÊÇ¼òµ¥µØÐ´ÈÕÖ¾¶øÒÑ
 * 
 * @author Tim Leung
 */
public class TestLogListerner implements TestExecutionListener {

	
	private transient static final Log log =LogFactory.getLog(TestLogListerner.class);
	
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public void afterTestClass(TestContext arg0) throws Exception {
		log.info("afterTestClass");
	}

	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public void afterTestMethod(TestContext arg0) throws Exception {
		log.info("afterTestMethod");
	}

	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public void beforeTestClass(TestContext arg0) throws Exception {
		log.info("beforeTestClass");
	}

	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public void beforeTestMethod(TestContext arg0) throws Exception {
		log.info("beforeTestMethod");
	}

	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public void prepareTestInstance(TestContext arg0) throws Exception {
		log.info("prepareTestInstance");
	}

	
}
