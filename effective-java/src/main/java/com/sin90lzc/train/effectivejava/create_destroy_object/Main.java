package com.sin90lzc.train.effectivejava.create_destroy_object;

public class Main {
	
	private static final class Point implements Cloneable{
		private int x;
		private int y;
		
		private String s=new String("x");
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		@Override
		public Point clone() throws CloneNotSupportedException {
			Point ret=(Point)super.clone();
			ret.s=new String(ret.s);
			return ret;
		}
		public String getS() {
			return s;
		}
		public void setS(String s) {
			this.s = s;
		}
	}
	
	public static void main(String[] args) throws Exception{
		Point a=new Point();
		Point b=new Point();
		a.setX(2);
		System.out.println(a.equals(b));
		Point ca=a.clone();
		System.out.println(ca.getS()==a.getS());
	}
}
