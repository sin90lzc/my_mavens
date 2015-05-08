/**
 *
 * created on 2015年4月25日 上午10:42:18
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.DispatcherServlet;

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

	@Test
	public void accessIndex() throws Exception {

		mockMvc.perform(get("/index.html"))
				.andExpect(
						MockMvcResultMatchers
								.request()
								.attribute(
										DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE,
										webApplicationContext))
				.andExpect(status().isOk());
	}

}
