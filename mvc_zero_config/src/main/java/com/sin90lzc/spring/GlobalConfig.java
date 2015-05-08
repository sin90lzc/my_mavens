package com.sin90lzc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages={"com.sin90lzc"})
@EnableWebMvc
public class GlobalConfig extends WebMvcConfigurerAdapter {
	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
		RequestMappingHandlerAdapter adapter=new RequestMappingHandlerAdapter();
		return adapter;
	}
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandler(){
		RequestMappingHandlerMapping mapping =new RequestMappingHandlerMapping();
		return mapping;
	}
	@Bean
	public ViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
	
	/**
	 * ��������defaultServletHandling�������ʲ���/WEB-INF/�µ��ļ�������ԭ�򻹲�̫����������������˸���֮�󣬲�������Ŀ��Ŀ¼��ʼ����
	 * override by Tim Leung
	 **/
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
