package com.sin90lzc.training.training_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试{@link List}对象
 * 
 * @author tim
 * 
 */
public class ListTest {

	private List<String> list = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
		Collections.addAll(list, "cat", "dog", "fish", "monkey");
	}

	/**
	 * 测试{@link List#add(Object)} {@link List#add(int, Object)}
	 * {@link List#addAll(java.util.Collection)}
	 * {@link List#addAll(int, java.util.Collection)}
	 * {@link List#remove(Object)} {@link List#removeAll(java.util.Collection)}
	 * 方法
	 */
	@Test
	public void testAddAndRemove() {
		String ch = "chicken";
		list.add(ch);
		Assert.assertEquals(5, list.size());
		list.add(ch);
		Assert.assertEquals(6, list.size());
		Assert.assertEquals(ch, list.get(4));
		Assert.assertEquals(ch, list.get(5));

		list.remove(ch);
		Assert.assertEquals(5, list.size());

		list.remove(ch);
		Assert.assertEquals(4, list.size());

		Assert.assertFalse(list.remove(ch));

		list.add(3, ch);
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(ch, list.get(3));

		list.remove(3);
		Assert.assertFalse(list.contains(ch));
		Assert.assertEquals(4, list.size());

		List<String> sub = Arrays.<String> asList("chicken", "mouse");
		list.addAll(sub);
		Assert.assertTrue(list.containsAll(sub));

		list.removeAll(sub);
		Assert.assertFalse(list.containsAll(sub));

		list.addAll(2, sub);
		Assert.assertEquals("chicken", list.get(2));
		Assert.assertEquals("mouse", list.get(3));
		Assert.assertTrue(list.containsAll(sub));

	}

	/**
	 * 测试{@link List#subList(int, int)}<br />
	 * 结论：<br />
	 * {@link List#subList(int, int)}
	 * 返回的子List是直接引用原List的区间段，因此子List的任何改变都会影响原List，原List的任何改变也会影响到子List。
	 */
	@Test
	public void testSubList() {
		Object[] array = list.toArray();
		List<String> sub = list.subList(1, 3);
		Assert.assertEquals(2, sub.size());
		Assert.assertEquals(array[1], sub.get(0));
		Assert.assertEquals(array[2], sub.get(1));
		Assert.assertEquals(list.get(1), sub.get(0));
		Assert.assertEquals(list.get(2), sub.get(1));
		Assert.assertEquals("dog", sub.get(0));
		Assert.assertEquals("fish", sub.get(1));

		sub.set(0, "chicken");
		Assert.assertEquals("chicken", sub.get(0));
		Assert.assertEquals("chicken", list.get(1));
		Assert.assertFalse("chicken".equals(array[1]));


		list.set(2, "mouse");
		Assert.assertEquals("mouse", sub.get(1));
		Assert.assertEquals("mouse", list.get(2));
		Assert.assertFalse("mouse".equals(array[2]));
		
		sub.add("pig");
		Assert.assertEquals("pig", sub.get(2));
		Assert.assertEquals("pig",list.get(3));
		Assert.assertTrue(list.size()==5);
		Assert.assertTrue(sub.size()==3);
		
	}

	/**
	 * {@link ListIterator}继承于{@link java.util.Iterator}，它可以实现双向迭代<br />
	 * 一个刚刚初始化的{@link ListIterator}可以认为他的初始化index=-1<br />
	 * 实际上next()返回的是list.get(++index);而previous()返回的是list.get(index--);<br />
	 * add(element)返回的是list.add(++index,element)，而remove()返回的是list.remove(index
	 * --);<br />
	 * 而nextIndex()返回的是index+1,而previous()返回的是index
	 */
	@Test
	public void testListIterator() {
		ListIterator<String> li = list.listIterator();

		// index=-1

		// 没有previous
		Assert.assertEquals(false, li.hasPrevious());
		Assert.assertEquals(true, li.hasNext());

		// index=-1
		Assert.assertEquals(0, li.nextIndex());

		// index=0
		Assert.assertEquals(list.get(li.nextIndex()), li.next());

		// 相当于list.set(index,element);
		li.set("mouse");

		// index=0
		Assert.assertEquals("mouse", list.get(li.previousIndex()));

		// index=-1
		Assert.assertEquals("mouse", li.previous());

		while (li.hasNext()) {
			li.next();
		}
		// 在remove之前，index=3;在remove之后，index=2.
		li.remove();
		Assert.assertEquals(3, list.size());

		// index=2
		Assert.assertEquals("fish", li.previous());

		// index=1
		li.add("chicken");
		Assert.assertEquals(4, list.size());

		// index=2
		Assert.assertEquals("chicken", li.previous());

		// index=1
	}

	@After
	public void tearDown() throws Exception {
		list.clear();
	}
}
