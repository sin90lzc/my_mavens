package com.sin90lzc.train.effectivejava.general.equal;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if(this==o){
			return true;
		}
		if (!getClass().isInstance(o)) {
			return false;
		}
		Point p = getClass().cast(o);
		return this.x == p.x && this.y == p.y;
	}

}
