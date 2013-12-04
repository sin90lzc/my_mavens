package com.sin90lzc.train.memcached;

public class SimpleHashFunction implements HashFunction {
	public int hash(Object obj) {
		return obj.hashCode();
	}
}
