package com.sin90lzc.train.train_spring_quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//TimeUnit.MINUTES.sleep(10);
	}

}
