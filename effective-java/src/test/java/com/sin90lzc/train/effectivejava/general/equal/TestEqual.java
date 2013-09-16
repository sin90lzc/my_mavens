package com.sin90lzc.train.effectivejava.general.equal;

import junit.framework.TestCase;

public class TestEqual extends TestCase{
	private Point point;
	private ColorPoint colorPoint;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		point=new Point(1,1);
		colorPoint=new ColorPoint(1, 1);
	}
	
	/**
	 * 这是测试equals方法对称性的反面例子。
	 * 对于超类的equals方法，不能只校验instanceof，还要校验getClass()是否相等。
	 */
	public void testSymmetry(){
		assertTrue(point.equals(colorPoint));
		assertFalse(colorPoint.equals(point));
	}
}
