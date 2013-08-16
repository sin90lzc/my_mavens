package com.sin90lzc.train.spring_rpc.rmi;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sin90lzc.train.spring_rpc.RPCService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class RMITest {
	@Test
	public void testRmi() {
		//System.out.println(rmiService.service("hello world!"));
		Assert.assertEquals("hello world!", rmiService.service("hello world!"));
	}

	@Resource(name = "rmiService")
	private RPCService rmiService;
}
