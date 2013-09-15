package com.sin90lzc.train.effectivejava.nestedclass;

/**
 * 静态成员类示例，可以看到，它不能引用外围类实例了！！
 * 静态成员类可以声明静态变量，而非静态成员类侧不可以。
 * @author Tim
 *
 */
public class StaticNestedClass {
	private int a;
	private static int b;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	StaticInnerClass getInnerClass(int a,int b){
		return new StaticInnerClass(a,b);
	}

	static class StaticInnerClass{
		static int a;//静态成员类可以声明静态变量，而非静态成员类侧不可以。
		
		StaticInnerClass(int a,int b){
			//由于是静态成员类，所以这里不能引用外围类实例了！！
			//StaticNestedClass.this.a=a;
		}
		
		static void print(){
		}
	}
}
