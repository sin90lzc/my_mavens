package com.sin90lzc.spring;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;

/**
 * copyright
 * 
 * all right reserved.
 * 
 * created on 2015年4月6日 上午11:28:01
 * 
 * @author Tim Leung
 */
public class SpringServlet extends HttpServlet {

	private DispatcherServlet springServlet = new DispatcherServlet();

	
	/**
	 * 
	 * 通过config
	 * 
	 * override by Tim Leung
	 **/
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
		app.register(GlobalConfig.class);
		app.setServletConfig(config);
	}
	
	/**
	 * 委派DispatcherServlet完成实际的请求分发
	 * override by Tim Leung
	 **/
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		springServlet.service(arg0, arg1);
	}

	
	
}
