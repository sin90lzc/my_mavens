package com.sin90lzc.train.effectivejava.nestedclass;

/**
 * ��̬��Ա��ʾ�������Կ�����������������Χ��ʵ���ˣ���
 * ��̬��Ա�����������̬���������Ǿ�̬��Ա��಻���ԡ�
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
		static int a;//��̬��Ա�����������̬���������Ǿ�̬��Ա��಻���ԡ�
		
		StaticInnerClass(int a,int b){
			//�����Ǿ�̬��Ա�࣬�������ﲻ��������Χ��ʵ���ˣ���
			//StaticNestedClass.this.a=a;
		}
		
		static void print(){
		}
	}
}
