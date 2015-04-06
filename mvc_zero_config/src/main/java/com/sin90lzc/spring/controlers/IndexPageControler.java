
package com.sin90lzc.spring.controlers;

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
 * created on 2015年4月6日 下午2:26:41
 * 
 * @author Tim Leung
 */
@Controller
public class IndexPageControler {
	
	@RequestMapping(value={"/","/index"},method={RequestMethod.GET})
	public ModelAndView handleIndex(HttpServletRequest req,HttpServletResponse res) throws Exception{
		return new ModelAndView("index");
	}
	@RequestMapping(value="/other",method={RequestMethod.GET})
	public ModelAndView handleOther(HttpServletRequest req,HttpServletResponse res) throws Exception{
		return new ModelAndView("other");
	}
	
}
