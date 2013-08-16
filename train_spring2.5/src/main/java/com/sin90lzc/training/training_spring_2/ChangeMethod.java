package com.sin90lzc.training.training_spring_2;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 * {@link MethodReplacer}实现,它用于替换整个方法
 * @author tim
 *
 */
public class ChangeMethod implements MethodReplacer {

	public Object reimplement(Object target, Method method, Object[] args)
			throws Throwable {
		return "message replaced";
	}
}
