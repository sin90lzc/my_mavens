
package com.sin90lzc.spring.controlers;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.LastModified;

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
public class IndexPageControler implements LastModified {
	
	@RequestMapping(value={"/","/index"},method={RequestMethod.GET})
	public ModelAndView handleIndex(HttpServletRequest req,HttpServletResponse res) throws Exception{
		parseReqAttribute(req);
		return new ModelAndView("index");
	}
	@RequestMapping(value="/other",method={RequestMethod.GET})
	public ModelAndView handleOther(HttpServletRequest req,HttpServletResponse res) throws Exception{
		return new ModelAndView("other");
	}
	
	
	
	
	private void parseReqAttribute(HttpServletRequest req){
		Enumeration e=req.getAttributeNames();
		while(e.hasMoreElements()){
			Object o=e.nextElement();
			Object v=req.getAttribute(String.valueOf(o));
			System.out.println(o+":"+v);
		}
	}
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public long getLastModified(HttpServletRequest request) {
		return System.currentTimeMillis();
	}
	
}
