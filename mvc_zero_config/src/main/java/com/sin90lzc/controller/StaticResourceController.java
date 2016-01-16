/**
 *
 * created on 2015��11��22�� ����4:25:04
 * 
 * @author Tim Leung
 */
package com.sin90lzc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
@Controller
@RequestMapping("resources/**")
public class StaticResourceController {

	@RequestMapping(value="*.html",method=RequestMethod.GET)
	public ModelAndView responseStaticHtml(HttpServletRequest request,HttpServletResponse response){
		Cookie c=new Cookie("XSRF-TOKEN","abcdef");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String filePath = requestURI.substring((contextPath+"/resources").length());
		c.setMaxAge(10);
		response.addCookie(c);
		ModelAndView mv=new ModelAndView(filePath);
		return mv;
	}
	
}
