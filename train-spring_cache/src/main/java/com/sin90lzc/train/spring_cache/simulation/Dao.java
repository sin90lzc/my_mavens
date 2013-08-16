package com.sin90lzc.train.spring_cache.simulation;

/**
 * 一个简单的Dao接口,我们要对这个接口的方法提供缓存的功能
 * @author Tim
 *
 */
public interface Dao {
	Object select(int id);
	void save(Object obj);
}
