package com.sin90lzc.train.spring_cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sin90lzc.train.spring_cache.simulation.Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-cache-xmlbase-config.xml")
public class XmlBaseCacheTest {
	@Autowired
	private Dao dao;

	private int key = 1;

	/**
	 * 如果这里的dao.save(key)中的key值改为一个非1值，那么CacheEvict注解将不会生效了
	 */
	@Test
	public void testCache() {

		for (int i = 0; i < 10; i++) {
			dao.select(key);
		}

		dao.save(key);

		for (int i = 0; i < 10; i++) {
			dao.select(key);
		}
	}
}
