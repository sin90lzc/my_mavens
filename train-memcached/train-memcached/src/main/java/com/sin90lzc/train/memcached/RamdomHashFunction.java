package com.sin90lzc.train.memcached;

public class RamdomHashFunction implements HashFunction {
	public int hash(Object obj) {
		double a = (Math.random() * Math.pow(2, 32));
		return new Double(a).intValue();
	}
}
