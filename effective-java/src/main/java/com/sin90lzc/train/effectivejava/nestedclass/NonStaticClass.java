package com.sin90lzc.train.effectivejava.nestedclass;

/**
 * �Ǿ�̬��Ա�಻��������̬����,��������������
 * �Ǿ�̬��Ա�಻�ܶ��徲̬����
 * �Ǿ�̬��Ա�����������Χ��ʵ��
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
		//�Ǿ�̬��Ա�಻��������̬����
		//static int a;
		final static int a=1;//��������������
		public NonStaticInnerClass(int a,int b){
			NonStaticClass.this.a=a;//����������Χ��ʵ��
			NonStaticClass.b=b;
		}
		//�Ǿ�̬��Ա�಻�ܶ��徲̬����
//		static void print(){
//			
//		}
	}
}
