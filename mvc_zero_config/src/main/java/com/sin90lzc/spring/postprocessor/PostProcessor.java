/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * 
 * 
 * @author Tim Leung
 */
@Component
public class PostProcessor implements BeanPostProcessor{

	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
//		System.out.println(beanName);
		return bean;
	}

}
