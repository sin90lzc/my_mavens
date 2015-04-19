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
	 * 如果不添加defaultServletHandling，将访问不了/WEB-INF/下的文件，具体原因还不太清楚，好像是设置了该置之后，才能以项目根目录开始访问
	 * override by Tim Leung
	 **/
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
