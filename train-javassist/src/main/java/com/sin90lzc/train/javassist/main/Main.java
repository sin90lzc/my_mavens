package com.sin90lzc.train.javassist.main;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import javax.swing.Box;

import com.sin90lzc.train.javassist.bean.MyClassLoader;
import com.sin90lzc.train.javassist.bean.Point;
import com.sin90lzc.train.javassist.bean.RecTangle;

public class Main {
	public static void main(String[] args) throws Exception{
		
		//testClassLoader();
		testCtClass();
	}
	
	public static void testClassLoader() throws Exception{
		RecTangle b=new RecTangle();
		MyClassLoader myLoader = new MyClassLoader();
		Class clazz = myLoader.loadClass("com.sin90lzc.train.javassist.bean.RecTangle");
		Object obj = clazz.newInstance();
		b = (RecTangle)obj;    // this always throws ClassCastException.
		b.build();
	}
	
	public static void testCtClass() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.sin90lzc.train.javassist.bean.RecTangle");
		cc.setSuperclass(pool.get("com.sin90lzc.train.javassist.bean.Point"));
		CtMethod method=cc.getDeclaredMethod("build");
		method.insertBefore("{System.out.println(\"before build!\");}");
		//cc.writeFile("./target/classes");
		Class abc=cc.toClass();
		((RecTangle)(abc.newInstance())).build();
		RecTangle rec=new RecTangle();
		rec.build();
		Point temp=Point.class.cast(rec);
		temp.sayHello();
	}
}
