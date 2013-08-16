package com.sin90lzc.training.training_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionTest {
	private Collection<String> collection = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
		Collections.addAll(collection, "cat", "dog", "fish", "monkey");
	}

	/**
	 * {@link Iterator}可以移除由{@link Iterator#next()}产生的最后一个元素，这意味着在调用
	 * {@link Iterator#remove()}之前必须先调用{@link Iterator#next()}<br />
	 * <br />
	 * 
	 */
	@Test
	public void testIteratorCanRemove() {
		Iterator<String> it = collection.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		Assert.assertEquals(0, collection.size());
	}

	/**
	 * 测试Java容器快速报错机制：当你迭代遍历某个容器的过程中，另一个进程介入其中，并且插入、删除或修改此容器内的某个对象，就会出现问题，并抛出
	 * {@link java.util.ConcurrentModificationException}异常
	 */
	@Test(expected = ConcurrentModificationException.class)
	public void testFastWrong() {
		Iterator<String> it = collection.iterator();
		collection.add("mouse");
		it.next();
	}

	@After
	public void tearDown() {
		collection.clear();
	}
}
