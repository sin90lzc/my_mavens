package com.sin90lzc.train.effectivejava.nestedclass;

import com.sin90lzc.train.effectivejava.nestedclass.NonStaticClass.NonStaticInnerClass;

import junit.framework.TestCase;

public class TestNestedClass extends TestCase{
	public void testNonStaticClass(){
		NonStaticClass nonStaticClass=new NonStaticClass();
		NonStaticInnerClass innerClass=nonStaticClass.getInnerClass(1,2);
		assertEquals(1, nonStaticClass.getA());
		assertEquals(2,NonStaticClass.b);
	}
}
