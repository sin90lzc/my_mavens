package com.sin90lzc.train.effectivejava.create_destroy_object.singleton;

/**
 * 使用静态工厂方法实现单例模式
 * @author Tim
 *
 */
public class StaticFactorySingleton {
	static{
		INSTANCE=new StaticFactorySingleton();
	}
	private static final StaticFactorySingleton INSTANCE;
	
	public static StaticFactorySingleton getInstance(){
		if(INSTANCE==null){
			throw new IllegalArgumentException("实例还没有实例化！");
		}
		return INSTANCE;
	}
}
