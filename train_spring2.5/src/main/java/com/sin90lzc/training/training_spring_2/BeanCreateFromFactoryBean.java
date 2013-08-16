package com.sin90lzc.training.training_spring_2;

import java.util.Calendar;

import org.springframework.beans.factory.FactoryBean;

public class BeanCreateFromFactoryBean implements FactoryBean {

	private Calendar cal = Calendar.getInstance();

	@Override
	public Object getObject() throws Exception {
		return cal;
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return cal.getClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
