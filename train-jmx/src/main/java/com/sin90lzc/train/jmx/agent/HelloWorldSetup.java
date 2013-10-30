package com.sin90lzc.train.jmx.agent;

import javax.management.ObjectName;

import com.sun.jdmk.comm.RmiConnectorClient;

public class HelloWorldSetup {
	public HelloWorldSetup() {
		try{
			RmiConnectorClient client=RMIClientFactory.getClient();
			ObjectName hwName=new ObjectName("JMXBookAgent:name=helloWorld");
			client.createMBean("com.sin90lzc.train.jmx.mbean.HelloWorld", hwName);//��jmx server��������mbean������
			client.invoke(hwName, "printGreeting", null, null);//����HellowWorld���mbean��printGreeting������
		}catch(Exception e){
			ExceptionUtil.printException(e);
		}
	}
	
	public static void main(String[] args) {
		new HelloWorldSetup();
	}
}
