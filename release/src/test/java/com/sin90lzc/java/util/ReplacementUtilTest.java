package com.sin90lzc.java.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class ReplacementUtilTest {
	
	private static final String SRC_TXT="���ã�${name}����ӭ����${place}!!";
	private static Map<String,Object> vars;
	
	@BeforeClass
	public static void setup(){
		vars=new HashMap<String,Object>();
		vars.put("name", "Tim Leung");
		vars.put("place", "������");
	}
	@Test
	public void testReplace(){
		String replaceTxt=ReplacementUtil.replace(SRC_TXT, vars);
		Assert.assertEquals("���ã�Tim Leung����ӭ����������!!", replaceTxt);
	}
}
