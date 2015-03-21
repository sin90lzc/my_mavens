package com.sin90lzc.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

public class BikeFactory implements ObjectFactory{

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx,
			Hashtable<?, ?> environment) throws Exception {
		Bike b=new Bike();
		b.setName("Trek 4700");
		b.setBrand("Treak");
		b.setSize(17);
		b.setVer("4700");
		return b;
	}

}
