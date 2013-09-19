package com.sin90lzc.train.jmx.agent;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.sun.jdmk.comm.RmiConnectorServer;

//jmx的agent,agent其实就是一个应用程序而已
public class JMXBookAgent {
	private MBeanServer server = null;

	public JMXBookAgent() {
		System.out.println("\n\tCreate the MBeanServer!");
		// jmx的server，该server的domain是JMXBookAgent
		server = MBeanServerFactory.createMBeanServer("JMXBookAgent");
		startHTMLAdapter();
		startRMIConnector();
	}

	private void startHTMLAdapter() {
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		ObjectName adapterName = null;
		try {
			// 设置html adapter的访问端口
			adapter.setPort(9092);
			// create the HTML adapter
			// 在jmx server中注册Html adapter，adapter Mbean的domain是JMXBookAgent，name属性是html，port属性是9092
			adapterName = new ObjectName("JMXBookAgent:name=html,port=9092");
			server.registerMBean(adapter, adapterName);
			adapter.start();//启动Html adapter
		} catch (Exception e) {
			System.out.println("Error Starting HTML Adapter for Agent!");
			ExceptionUtil.printException(e);
		}
	}

	private void startRMIConnector() {
		RmiConnectorServer connector=new RmiConnectorServer();
		ObjectName connectorName=null;
		try{
			// 在jmx server中注册RMIConnetor，RMIConnetor Mbean的domain是JMXBookAgent，name属性是RMIConnector，port属性是9092
			connector.setPort(2099);
			connectorName=new ObjectName("JMXBookAgent:name=RMIConnector");
			server.registerMBean(connector, connectorName);
			connector.start();
		}catch(Exception ex){
			ExceptionUtil.printException(ex);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Starting the agent!");
		System.out.println("Preparing the agent!");
		new JMXBookAgent();
		System.out.println("Agent is Ready for service...");
	}
}
