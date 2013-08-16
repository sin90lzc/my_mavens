package com.sin90lzc.train.spring_annotation;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AnnotationTest {
	@Autowired
	private ApplicationContext context;

	private Service service;

	@Test
	public void testAnnotation() {
		Assert.assertNotNull(context);
		Assert.assertNotNull(service);
		service.service();
		Service s = (Service) context.getBean("serviceImpl");
		s.service();
	}

	@Resource
	public void setService(Service s) {
		this.service = s;
	}
}
