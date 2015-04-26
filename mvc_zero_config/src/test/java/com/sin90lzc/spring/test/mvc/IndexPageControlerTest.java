/**
 *
 * created on 2015年4月25日 上午10:42:18
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.mvc;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.sin90lzc.spring.test.base.BaseMvcTest;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年4月25日 上午10:42:18
 * 
 * @author Tim Leung
 */
public class IndexPageControlerTest extends BaseMvcTest {

	@Before
	public void setup(){
		mockMvc	= MockMvcBuilders.webApplicationContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void accessIndex() throws Exception{
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
}
