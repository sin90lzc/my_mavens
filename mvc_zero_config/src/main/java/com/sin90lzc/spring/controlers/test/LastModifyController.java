/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.controlers.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.LastModified;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
@Controller
@RequestMapping(value="test")
@SessionAttributes("a")
public class LastModifyController implements LastModified{

	
	@RequestMapping(value="lastModify")
	public ModelAndView lastModify(@ModelAttribute(value="a")String abc,Model model){
		model.addAttribute("a", "abc");
		return new ModelAndView("test/lastModify");
	}
	@RequestMapping(value="pet/{pet}")
	public ModelAndView parseUrl(@ModelAttribute("pet") String bb,Model model){
		System.out.println("xx");
		return new ModelAndView("redirect:/test/lastModify"); 
	}
	
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public long getLastModified(HttpServletRequest request) {
		return 1;
	}
	
}
