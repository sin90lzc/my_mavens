package com.sin90lzc.training.training_jdbc;

import java.io.IOException;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.PropertyConfigurator;

public class BaseTestForJdbc extends TestCase {

	protected static Properties props;
	static {
		props = new Properties();
		Properties log4j = new Properties();
		try {
			props.load(BaseTestForJdbc.class.getClassLoader()
					.getResourceAsStream("jdbc.properties"));
			log4j.load(BaseTestForJdbc.class.getClassLoader()
					.getResourceAsStream("log4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(log4j);
	}
}
