package com.sin90lzc.train.effectivejava.create_destroy_object;

import java.util.HashMap;
import java.util.Map;

/**
 * ʹ�þ�̬���������򻯷��Ͷ����ʵ����
 * @author Tim
 *
 */
public class MapUtil {
	public static <K,V> Map<K,V> newInstance(){
		return new HashMap<K,V>();
	}
}
