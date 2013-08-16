package com.sin90lzc.train.spring_cache.simulation;

import java.util.HashMap;
import java.util.Map;
/**
 * 实现缓存功能，在Spring中，该类可以看作是Advice
 * @author Tim
 *
 */
public class Cache {
	private static final Map<String, Object> cache = new HashMap<String, Object>();
	
	/**
	 * 把对象添加到缓存中去
	 * @param key
	 * @param value
	 */
	public void checkIn(String key, Object value) {
		if (!cache.containsKey(key)) {
			cache.put(key, value);
		}
	}

	/**
	 * 从缓存中找对象
	 * @param key
	 * @return
	 */
	public Object checkOut(String key) {
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		return null;
	}
	
	/**
	 * 在方法执行前清除缓存
	 */
	public void clearCacheBeforeMethod(){
		cache.clear();
	}
	
	/**
	 * 在方法执行后清除缓存
	 */
	public void clearCacheAfterMethod(){
		cache.clear();
	}
}