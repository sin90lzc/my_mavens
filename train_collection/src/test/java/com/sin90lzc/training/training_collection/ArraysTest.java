package com.sin90lzc.training.training_collection;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 测试{@link Arrays}类
 * 
 * @author tim
 * 
 */
public class ArraysTest {

	/**
	 * 测试{@link Arrays#asList(Object...)}方法。该方法返回的{@link List}
	 * 底层上依然是个数组，因此它的大小是不能改变的。任何企图改变List大小的操作都会抛出
	 * {@link UnsupportedOperationException}异常<br />
	 * 
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testAsList() {
		List<String> animals = Arrays.<String> asList("dog", "cat", "fish",
				"monkey");
		animals.set(0, "chicken");
		Assert.assertEquals("chicken", animals.get(0));
		
		//操作下面两个方法会抛出UnsupportedOperationException异常
		animals.add("checken");
		animals.remove("cat");
	}
}
