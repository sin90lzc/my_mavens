package com.sin90lzc.train.spring_annotation;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl2 implements Dao{

	@Override
	public Object select() {
		System.out.println("DaoImpl2.select");
		return null;
	}

	@Override
	public void save(Object o) {
		System.out.println("DaoImpl2.save");
	}

}
