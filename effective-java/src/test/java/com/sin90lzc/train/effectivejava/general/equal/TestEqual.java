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
	 * ���ǲ���equals�����Գ��Եķ������ӡ�
	 * ���ڳ����equals����������ֻУ��instanceof����ҪУ��getClass()�Ƿ���ȡ�
	 */
	public void testSymmetry(){
		assertTrue(point.equals(colorPoint));
		assertFalse(colorPoint.equals(point));
	}
}
