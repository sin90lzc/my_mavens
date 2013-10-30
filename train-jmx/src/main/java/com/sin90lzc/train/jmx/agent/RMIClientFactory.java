package com.sin90lzc.train.jmx.agent;

import com.sun.jdmk.comm.RmiConnectorAddress;
import com.sun.jdmk.comm.RmiConnectorClient;
/**
 * 生成RMIConnetor的客户端
 * @author Tim
 *
 */
public class RMIClientFactory {
	public static RmiConnectorClient getClient(){
		RmiConnectorClient client=new RmiConnectorClient();
		RmiConnectorAddress address=new RmiConnectorAddress();
		address.setPort(2099);
		System.out.println("Connector Type="+address.getConnectorType());
		System.out.println("PORT="+address.getPort());
		System.out.println("HOST="+address.getHost());
		System.out.println("SERVER="+address.getHost());
		try{
			client.connect(address);
		}catch(Exception e){
			ExceptionUtil.printException(e);
		}
		return client;
	}
}
