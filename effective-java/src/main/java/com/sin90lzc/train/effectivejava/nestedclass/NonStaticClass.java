package com.sin90lzc.train.effectivejava.nestedclass;

/**
 * 非静态成员类不能声明静态变量,但可以声明常量
 * 非静态成员类不能定义静态方法
 * 非静态成员类可以引用外围类实例
 * @author Tim
 *
 */
public class NonStaticClass {
	private int a;
	static int b;
	
	
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}
	
	public NonStaticInnerClass getInnerClass(int a,int b){
		return new NonStaticInnerClass(a,b);
	}

	class NonStaticInnerClass{
		//非静态成员类不能声明静态变量
		//static int a;
		final static int a=1;//但可以声明常量
		public NonStaticInnerClass(int a,int b){
			NonStaticClass.this.a=a;//可以引用外围类实例
			NonStaticClass.b=b;
		}
		//非静态成员类不能定义静态方法
//		static void print(){
//			
//		}
	}
}
