package com.sin90lzc.train.spring_annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

@Repository()
public class DaoImpl implements Dao, BeanPostProcessor {

	public DaoImpl() {
		System.out.println("DaoImpl.constructor");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(beanName+" before");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(beanName+" after");
		return bean;
	}

	@Override
	public Object select() {
		System.out.println("DaoImpl.select");
		return null;
	}

	@Override
	public void save(Object o) {
		System.out.println("DaoImpl.save");
	}

}
