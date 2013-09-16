package com.sin90lzc.train.effectivejava.create_destroy_object;

import java.util.Map;

import junit.framework.TestCase;

/**
 * 使用静态工厂方法来简化泛型对像的实例化
 * @author Tim
 *
 */
public class TestMapUtil extends TestCase{
	
	Map<String,Integer> testMap;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testMap=MapUtil.newInstance();
	}
	
	public void testMapUtil(){
		testMap.put("1", 1);
	}
}
