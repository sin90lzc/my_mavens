package com.sin90lzc.train.spring_cache.simulation;

/**
 * Dao的代理对象，它不仅仅完成主要的查询，存储操作，还实现了缓存
 * 
 * @author Tim
 * 
 */
public class DaoProxy implements Dao {
	private Cache cache;// 该对象实现了缓存的功能
	private Dao dao;// 完成主要查询，存储操作的Dao实现类,注意，这是一个Dao的实现类

	public Object select(int id) {
		// 在执行方法前，尝试从缓存中取出结果并返回，如果没找到，则执行实际的操作。
		Object obj = cache.checkOut("Dao.select");
		boolean hasCache = false;
		if (obj != null) {
			hasCache = true;
			return obj;
		}

		// 实际的查询操作
		obj = dao.select(id);

		// 如果在缓存中找不到该方法的结果，缓存该结果
		if (!hasCache) {
			cache.checkIn("Dao.select", obj);
		}
		return obj;
	}

	public void save(Object obj) {
		// 在执行方法前清除缓存
		cache.clearCacheBeforeMethod();
		// 实际的操作
		dao.save(obj);
		// 在执行方法后清除缓存
		cache.clearCacheAfterMethod();
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

}
