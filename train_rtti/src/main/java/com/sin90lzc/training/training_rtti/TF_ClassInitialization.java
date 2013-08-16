package com.sin90lzc.training.training_rtti;

import java.util.Random;

/**
 * 该类用于测试类初始化的。类的初始化是指对静态初始化器和静态初始化块的调用。测试证明了以下几点：
 * <ul>
 * <li>调用".class"不会初始化。</li>
 * <li>调用Class.forName会进行初始化。</li>
 * <li>调用常数静态域不会进行初始化</li>
 * <li>调用构造方法会进行初始化</li>
 * </ul>
 * 
 * @author tim
 * @version 1.0
 */
public class TF_ClassInitialization {

	public static Random rand = new Random(47);

	static class Initable {
		static final int staticFinal = 47;
		static final int staticFinal2 = rand.nextInt(1000);
		static {
			System.out.println("Initializing Initable");
		}

		Initable() {
			System.out.println("execute Initable3 constructor");
		}
	}

	static class Initable2 {
		static int staticNonFinal = 147;
		static {
			System.out.println("Initializing Initable2");
		}

		Initable2() {
			System.out.println("execute Initable2 constructor");
		}
	}

	static class Initable3 {
		static int staticNonFinal = 74;
		static {
			System.out.println("Initialing Initable3");
		}

		Initable3() {
			System.out.println("execute Initable3 constructor");
		}
	}

	static class Initable4 {
		static final String staticFinalString = "staticFinalString";
		static {
			System.out.println("Initialing Initable4");
		}

		Initable4() {
			System.out.println("execute Initable4 constructor");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNonFinal);
		Class initable3 = Class
				.forName("com.sin90lzc.training.training_rtti.TF_ClassInitialization$Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
		System.out.println(Initable4.staticFinalString);
		System.out.println(Initable4.class.newInstance());
	}

}
