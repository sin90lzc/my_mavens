package com.sin90lzc.training.training_spring_2.aop;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import com.sin90lzc.test.util.ClassInfo;

public class AOPTest extends TestCase {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"ApplicationContext_aop.xml");

	/**
	 * 该方法测试使用代理工厂Bean创建代理对象的方式
	 */
	public void testFactoryProxy() {
		System.out
				.println("--------------------------------------测试使用代理工厂Bean创建代理对象的方式----------------------");
		Artist singer = (Artist) context.getBean("singerProxy");
		ClassInfo.printClassInfo(singer.getClass());
		singer.perform();
	}

	/**
	 * 该方法测试自动生成代理Bean
	 */
	public void testAutoProxy() {
		System.out
				.println("--------------------------------------测试自动生成代理Bean----------------------");
		Singer singer = (Singer) context.getBean("singer");
		singer.perform();
	}

}
