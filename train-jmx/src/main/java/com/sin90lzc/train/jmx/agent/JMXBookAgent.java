package com.sin90lzc.train.jmx.agent;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class JMXBookAgent {
	private MBeanServer server=null;
	public JMXBookAgent(){
		System.out.println("\n\tCreate the MBeanServer!");
		server=MBeanServerFactory.createMBeanServer("JMXBookAgent");
		startHTMLAdapter();
		startRMIConnector();
	}
	
	private void startHTMLAdapter(){
	}
	
	private void startRMIConnector(){
		
	}
}
