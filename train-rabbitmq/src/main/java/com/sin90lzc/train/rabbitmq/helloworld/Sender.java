/**
 * 
 */
package com.sin90lzc.train.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * copyright PPMoney
 * 
 * 
 * @author liangzhicong
 * 
 *         create at 2015年5月8日 下午2:52:32
 */
public class Sender {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws java.io.IOException {
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("172.31.0.254");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    String message = "Hello World!";
	    
	    for(int i=0;i<100;i++){
	    
	    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
	    }
	    System.out.println(" [x] Sent '" + message + "'");
	    
	    channel.close();
	    connection.close();
	}
}
