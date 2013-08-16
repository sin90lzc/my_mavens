package com.sin90lzc.train.spring_cache.simulation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


@Component
public class DaoImpl implements Dao {

	/**
	 * value定义了缓存区（缓存区的名字），每个缓存区可以看作是一个Map对象
	 * key作为该方法结果缓存的唯一标识，
	 */
	@Cacheable(value = { "dao.select" },key="#id")
	@Override
	public Object select(int id) {
		System.out.println("do in function select()");
		return new Object();
	}

	@CacheEvict(value = { "dao.select" }, key="#obj")
	@Override
	public void save(Object obj) {
		System.out.println("do in function save(obj)");
	}

}
