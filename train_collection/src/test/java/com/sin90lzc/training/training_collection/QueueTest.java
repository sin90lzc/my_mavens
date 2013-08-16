package com.sin90lzc.training.training_collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

/**
 * 这里展示了{@link Queue}的一般用法，也展示了{@link PriorityQueue}会根据{@link Comparator}自动地维护队列的排序
 * 
 * @author tim
 * 
 */
public class QueueTest {
	private Queue<Object> queue;

	@Before
	public void setup() {
		queue = new PriorityQueue<Object>();
		queue.addAll(Arrays.asList(("ODJFZCV;;'DFJIJDSOJF[QICVN,DI".split(""))));
	}

	@Test
	public void testPoll() {
		while (!queue.isEmpty()) {
			System.out.print(queue.poll());
		}
		System.out.println();
	}

	@Test
	public void testReversePoll() {
		Queue<Object> reverse = new PriorityQueue<Object>(100,
				Collections.reverseOrder());
		reverse.addAll(queue);
		while (!reverse.isEmpty()) {
			System.out.print(reverse.poll());
		}
		System.out.println();
	}

}
