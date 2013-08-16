package com.sin90lzc.training.training_log4j;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class BaseLogger {
	private static Logger LOG = Logger.getLogger("com.sin90lzc.log.base");
	private static Logger ROOT = Logger.getRootLogger();

	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		// LOG.setLevel(Level.INFO);
		// ROOT.setLevel(Level.INFO);
		ROOT.addAppender(new FileAppender(new SimpleLayout(), "target/log"));
		LOG.debug("Application start!");
		ROOT.debug("ok");
	}

}
