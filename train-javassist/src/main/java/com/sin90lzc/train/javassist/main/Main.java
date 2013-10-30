package com.sin90lzc.train.javassist.main;

import javassist.ClassPool;
import javassist.CtClass;

public class Main {
	public static void main(String[] args) throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.Rectangle");
		cc.setSuperclass(pool.get("test.Point"));
		cc.writeFile();
	}
}
