package com.sin90lzc.training.training_log4j;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertyLogger {
	public static String LOG_CONFIG = "log4j.properties";
	static Logger logger = Logger.getLogger("com.sin90lzc.log.propertyLogger");

	public static void main(String[] args) throws Exception {
		// PropertyConfigurator.configure("log4j.properties");
		Properties properties = new Properties();
		properties.load(PropertyLogger.class.getClassLoader()
				.getResourceAsStream(LOG_CONFIG));
		PropertyConfigurator.configure(properties);
		logger.info("start!");
		logger.debug("abc");
	}
}
