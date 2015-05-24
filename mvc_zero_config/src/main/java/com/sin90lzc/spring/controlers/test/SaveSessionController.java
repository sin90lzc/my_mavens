/**
 *
 * created on 2015年5月17日 下午10:14:48
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.controlers.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年5月17日 下午10:14:48
 * 
 * @author Tim Leung
 */
@Controller
@RequestMapping(value="test")
public class SaveSessionController {
	@RequestMapping(value="saveSession")
	public ModelAndView saveSession(HttpSession session){
		session.setAttribute("a", "abc");
		return new ModelAndView("test/lastModify"); 
	}
	
	
	
}
