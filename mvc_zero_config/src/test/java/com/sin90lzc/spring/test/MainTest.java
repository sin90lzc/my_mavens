/**
 *
 * created on 2015年5月25日 下午10:18:27
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.sin90lzc.spring.GlobalConfig;
import com.sin90lzc.spring.TestConfig;
import com.sin90lzc.spring.test.db.DAO;


/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年5月25日 下午10:18:27
 * 
 * @author Tim Leung
 */
public class MainTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(GlobalConfig.class);
		context.register(TestConfig.class);
		context.setServletConfig(new MockServletConfig());
		context.refresh();
		
		DAO dao = context.getBean(DAO.class);
		
		
		ExecutorService es = Executors.newFixedThreadPool(20);
		
		for(int i=0;i<20;i++){
			es.execute(new TransiactionJob(dao));
//			new Thread(new TransiactionJob(dao)).start();
		}
		
		es.shutdown();
	}
	
	private static class TransiactionJob implements Runnable{

		private DAO dao;
		private static int count=0;
		private final int id=++count;
		
		TransiactionJob(DAO dao){
			this.dao=dao;
		}
		
		/**
		 * 
		 * override by Tim Leung
		 **/
		@Override
		public void run() {
			try{
				long last=System.currentTimeMillis();
				dao.save();
				System.out.println("task:"+id+" finish at " +(System.currentTimeMillis()-last));
			}catch(Exception e){
				
			}
		}
		
	}
	
}
