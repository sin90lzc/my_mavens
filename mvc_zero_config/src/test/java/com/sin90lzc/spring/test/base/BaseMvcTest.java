/**
 *
 * created on 2015年4月25日 上午11:09:13
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.base;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年4月25日 上午11:09:13
 * 
 * @author Tim Leung
 */
public class BaseMvcTest extends BaseTest{

	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	
	protected MockMvc mockMvc;
	
	@Before
	public void __setup__(){
		mockMvc=MockMvcBuilders.webApplicationContextSetup(webApplicationContext).build();
	}
	
}
