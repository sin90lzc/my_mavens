package com.sin90lzc.training.training_springMVC.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HomePageController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("hello_world", "Hello World!");
		return new ModelAndView("index",map);
	}
	
}
