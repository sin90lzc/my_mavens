/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.base;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
public class BaseMvcTest extends BaseTest{

	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	
	protected MockMvc mockMvc;
	
	@Before
	public void __setup__(){
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
}
