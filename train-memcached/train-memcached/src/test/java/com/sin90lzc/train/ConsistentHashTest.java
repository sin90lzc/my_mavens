package com.sin90lzc.train;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.sin90lzc.train.memcached.ConsistentHash;
import com.sin90lzc.train.memcached.SimpleHashFunction;

public class ConsistentHashTest extends TestCase{

	public void testAdd() {

	}

	public void testConsistentHash() {
		ConsistentHash<Integer> ch = new ConsistentHash<Integer>(
				new SimpleHashFunction(), 2, null);
		for (int node = 900000; node > 899900; node--) {
			ch.add(node);
		}

		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		for (int obj = 0; obj < 1000; obj++) {
			Integer node = ch.get(obj);
			if (result.containsKey(node)) {
				int count = result.get(node);
				result.put(node, ++count);
			} else {
				result.put(node, 1);
			}
		}

		System.out.println(result);
	}
}
