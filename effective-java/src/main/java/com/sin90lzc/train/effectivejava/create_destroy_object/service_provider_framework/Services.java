package com.sin90lzc.train.effectivejava.create_destroy_object.service_provider_framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * �����ṩ��ע��API�ͷ������API�������ﶨ��
 * @author Tim
 *
 */
public class Services {
	private Services(){}
	
	private static final Map<String,Provider> providers=new ConcurrentHashMap<String,Provider>();
	
	public static final String DEFAULT_PROVIDER_NAME="<def>";
	
	//�����ṩ��ע��API
	public static void registerDefaultProvider(Provider p){
		registerProvider(DEFAULT_PROVIDER_NAME,p);
	}
	
	public static void registerProvider(String name,Provider p){
		providers.put(name, p);
	}
	
	//�������API
	public static Service newInstance(){
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	public static Service newInstance(String name){
		Provider p=providers.get(name);
		if(p==null){
			throw new IllegalArgumentException("No provider registered with name: "+name);
		}
		return p.newService();
	}
}
