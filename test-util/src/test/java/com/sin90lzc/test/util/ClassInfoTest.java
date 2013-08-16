package com.sin90lzc.test.util;

import junit.framework.TestCase;

public class ClassInfoTest extends TestCase {
	private static Object obj = new MyObject();

	public void testPrintClassInfo() {
		ClassInfo.printClassInfo(obj.getClass());
	}
	
	public static class MyObject{
		private String abc;
		private String getAbc(){
			return abc;
		}
	}
}
