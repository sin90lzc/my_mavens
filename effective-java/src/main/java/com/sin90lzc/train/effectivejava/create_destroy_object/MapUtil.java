package com.sin90lzc.train.effectivejava.create_destroy_object;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用静态工厂方法简化泛型对象的实例化
 * @author Tim
 *
 */
public class MapUtil {
	public static <K,V> Map<K,V> newInstance(){
		return new HashMap<K,V>();
	}
}
