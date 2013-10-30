package com.sin90lzc.train.jmx.agent;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.sun.jdmk.comm.RmiConnectorServer;

//jmx��agent,agent��ʵ����һ��Ӧ�ó������
public class JMXBookAgent {
	private MBeanServer server = null;

	public JMXBookAgent() {
		System.out.println("\n\tCreate the MBeanServer!");
		// jmx��server����server��domain��JMXBookAgent
		server = MBeanServerFactory.createMBeanServer("JMXBookAgent");
		startHTMLAdapter();
		startRMIConnector();
	}

	private void startHTMLAdapter() {
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		ObjectName adapterName = null;
		try {
			// ����html adapter�ķ��ʶ˿�
			adapter.setPort(9092);
			// create the HTML adapter
			// ��jmx server��ע��Html adapter��adapter Mbean��domain��JMXBookAgent��name������html��port������9092
			adapterName = new ObjectName("JMXBookAgent:name=html,port=9092");
			server.registerMBean(adapter, adapterName);
			adapter.start();//����Html adapter
		} catch (Exception e) {
			System.out.println("Error Starting HTML Adapter for Agent!");
			ExceptionUtil.printException(e);
		}
	}

	private void startRMIConnector() {
		RmiConnectorServer connector=new RmiConnectorServer();
		ObjectName connectorName=null;
		try{
			// ��jmx server��ע��RMIConnetor��RMIConnetor Mbean��domain��JMXBookAgent��name������RMIConnector��port������9092
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
