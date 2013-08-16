package com.sin90lzc.training.training_spring_2.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class AudienceAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice, ThrowsAdvice {

	private final Audience audience;
	
	public AudienceAdvice(Audience audience) {
		this.audience=audience;
	}
	
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("enter afterReturning() Method");
		//System.out.println(returnValue.getClass().getName());
		audience.applaud();
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		audience.takeSeats();
		audience.turnOffCellPhones();
	}

	public void afterThrowing(Throwable throwable) {
		audience.demandRefund();
	}
}
