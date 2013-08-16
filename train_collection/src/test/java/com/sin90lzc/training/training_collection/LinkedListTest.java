package com.sin90lzc.training.training_collection;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link LinkedList}采用了双向链表的数据结构，因此在执行插入和移除操作时比ArrayList更高效，但在随机访问操作方面却要逊色一些<br />
 * {@link LinkedList}实现了{@link List}和{@link Deque}({@link Deque}继承了{@link Queue}
 * ),因此，LinkedList除了有列表的特性外，还具有队列（双向队列）的特性，正是这个原因，LinkedList中有很多方法都具有功能相似或相同，
 * 而名称不一样的方法：<br />
 * <br/>
 * 1.{@link Deque#getFirst()} {@link Queue#element()} {@link Queue#peek()}
 * 三个方法都返回容器的第一个元素，{@link Deque#getFirst()} {@link Queue#element()}在容器为空时抛出
 * {@link NoSuchElementException}异常，而{@link Queue#peek()}在容器为空时返回null<br />
 * <br />
 * 2.{@link Queue#remove()} {@link Deque#removeFirst()} {@link Queue#poll()}
 * 三个方法都返回容器的第一个元素并移除该元素，{@link Queue#remove()} {@link Deque#removeFirst()}
 * 在容器为空时抛出{@link NoSuchElementException}异常，而{@link Queue#poll()}在容器为空时返回null
 * 
 * @author tim
 * 
 */
public class LinkedListTest {

	private LinkedList<String> linkedList = new LinkedList<String>();

	@Before
	public void setup() {
		Collections.addAll(linkedList, "cat", "dog", "fish", "monkey");
	}

	@Test
	public void testQueue() {

	}

	// 测试对比getFirst()，element()，peek()
	@Test(expected = NoSuchElementException.class)
	public void testGetFirst() {
		Assert.assertEquals("cat", linkedList.getFirst());
		linkedList.clear();
		Assert.assertEquals(0, linkedList.size());

		// 容器为空时，抛出NoSuchElementException
		linkedList.getFirst();
	}

	@Test(expected = NoSuchElementException.class)
	public void testElement() {
		Assert.assertEquals("cat", linkedList.element());
		linkedList.clear();
		Assert.assertEquals(0, linkedList.size());

		// 容器为空时，抛出NoSuchElementException
		linkedList.element();
	}

	@Test
	public void testPeek() {
		Assert.assertEquals("cat", linkedList.peek());
		linkedList.clear();
		Assert.assertEquals(0, linkedList.size());

		// 当容器为空时，返回NULL
		Assert.assertNull(linkedList.peek());
	}

	// 测试remove()，removeFirst()，poll()
	@Test(expected = NoSuchElementException.class)
	public void testRemove() {
		Assert.assertEquals("cat", linkedList.remove());
		Assert.assertEquals(3, linkedList.size());

		linkedList.clear();
		Assert.assertEquals(0, linkedList.size());

		// 容器为空时，抛出NoSuchElementException
		linkedList.remove();
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirst() {
		Assert.assertEquals("cat", linkedList.removeFirst());
		Assert.assertEquals(3, linkedList.size());

		linkedList.clear();
		Assert.assertEquals(0, linkedList.size());

		// 容器为空时，抛出NoSuchElementException
		linkedList.removeFirst();
	}

	@Test
	public void testPoll() {
		Assert.assertEquals("cat", linkedList.poll());
		Assert.assertEquals(3, linkedList.size());

		linkedList.clear();
		Assert.assertEquals(0, linkedList.size());

		// 容器为空时，返回null
		Assert.assertNull(linkedList.poll());
	}

	@After
	public void tearDown() {
		linkedList.clear();
	}
}
