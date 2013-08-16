package com.sin90lzc.train.spring_annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceImpl")
public class ServiceImpl implements Service {
	private Dao dao;

	@Resource(name = "daoImpl2")
	private Dao dao2;

	public ServiceImpl() {
		System.out.println("ServiceImpl.constructor");
	}

	@Autowired(required = true)
	public void setDao(@Qualifier("daoImpl") Dao dao) {
		this.dao = dao;
	}

	@Override
	public void service() {
		dao.select();
		dao.save(null);
		dao2.select();
		dao2.save(null);
	}
}
