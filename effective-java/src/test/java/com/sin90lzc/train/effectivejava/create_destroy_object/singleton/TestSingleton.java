package com.sin90lzc.train.effectivejava.create_destroy_object.singleton;

import junit.framework.TestCase;

public class TestSingleton extends TestCase{
	
	public void testStaticFactorySingleton(){
		StaticFactorySingleton a=StaticFactorySingleton.getInstance();
		StaticFactorySingleton b=StaticFactorySingleton.getInstance();
		assertSame(b, a);
	}
	
	public void testEnumSingleton(){
		assertTrue(EnumSingleton.INSTANCE instanceof EnumSingleton);
		assertSame(EnumSingleton.INSTANCE,EnumSingleton.INSTANCE);
	}
}
