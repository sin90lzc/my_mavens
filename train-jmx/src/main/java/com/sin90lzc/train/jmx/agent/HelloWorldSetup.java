package com.sin90lzc.train.jmx.agent;

import javax.management.ObjectName;

import com.sun.jdmk.comm.RmiConnectorClient;

public class HelloWorldSetup {
	public HelloWorldSetup() {
		try{
			RmiConnectorClient client=RMIClientFactory.getClient();
			ObjectName hwName=new ObjectName("JMXBookAgent:name=helloWorld");
			client.createMBean("com.sin90lzc.train.jmx.mbean.HelloWorld", hwName);//向jmx server发送新增mbean的请求
			client.invoke(hwName, "printGreeting", null, null);//调用HellowWorld这个mbean的printGreeting方法。
		}catch(Exception e){
			ExceptionUtil.printException(e);
		}
	}
	
	public static void main(String[] args) {
		new HelloWorldSetup();
	}
}
