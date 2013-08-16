package com.sin90lzc.training.training_collection;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 该类证明了只有数组或{@link Iterable}对象可以使用foreach形式的循环。这里也证明了数组并不是一个{@link Iterable}对象
 * 
 * @author tim
 * 
 */
public class IterableTest {

	private static final String DATA = "good good study day day up";

	Iterable<String> it = new IterableClass<String>(DATA.split(" "));

	@Test
	public void testForEach() {
		StringBuffer sb = new StringBuffer();
		for (String s : it) {
			sb.append(s).append(" ");
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));
		Assert.assertEquals(DATA, sb.toString());
	}

	@Test
	public void testArray() {
		String[] ss = DATA.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String s : ss) {
			sb.append(s).append(" ");
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));
		Assert.assertEquals(DATA, sb.toString());
	}

	@Test(expected = ClassCastException.class)
	public void testArrayNotAIterable() {
		String[] ss = DATA.split(" ");
		Iterable.class.cast(ss);
	}
}
