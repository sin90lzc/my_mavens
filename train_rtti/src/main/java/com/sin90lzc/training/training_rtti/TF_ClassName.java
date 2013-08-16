/*
 create at 2012-05-08
 */
package com.sin90lzc.training.training_rtti;

/**
 * 该类用于查看{@link java.lang.Class#getName()},
 * {@link java.lang.Class#getCanonicalName()},
 * {@link java.lang.Class#getSimpleName()}之间的区别
 * 
 * @author tim
 * @version 1.0
 */
public class TF_ClassName {

	interface HasBatteries {
	}

	interface Waterproof {
	}

	interface Shoots {
	}

	/**
	 * 注意，内部类必须为static，才能通过{@link java.lang.Class#newInstance()}实例化。
	 * @author tim
	 *
	 */
	public static class Toy {
		Toy() {

		}

		Toy(int i) {
		}
	}

	class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
		public FancyToy() {
			super(1);
		}
	}

	/**
	 * 该静态方法用于打印clazz类的信息
	 * 
	 * @param clazz
	 *            要打印的类
	 */
	public static void printInfo(Class clazz) {
		System.out.println("Class Name: " + clazz.getName()
				+ " is interface? [" + clazz.isInterface() + "]");
		System.out.println("Simple Name: " + clazz.getSimpleName());
		System.out.println("Canonical Name: " + clazz.getCanonicalName());
		System.out.println("--------------------------------------------");
	}

	public static void main(String[] args) throws Exception {
		Class c = null;
		c = Class
				.forName("com.sin90lzc.training.training_rtti.TF_ClassName$FancyToy");
		printInfo(c);
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = up.newInstance();
		printInfo(obj.getClass());
		
		//测试数组数据
		String[] abs={"a","b","c"};
		printInfo(abs.getClass());
	}
}
