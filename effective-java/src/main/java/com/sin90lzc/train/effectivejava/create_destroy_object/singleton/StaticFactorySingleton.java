package com.sin90lzc.train.effectivejava.create_destroy_object.singleton;

/**
 * ʹ�þ�̬��������ʵ�ֵ���ģʽ
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
			throw new IllegalArgumentException("ʵ����û��ʵ������");
		}
		return INSTANCE;
	}
}
