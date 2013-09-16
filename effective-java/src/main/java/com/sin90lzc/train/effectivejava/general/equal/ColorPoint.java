package com.sin90lzc.train.effectivejava.general.equal;

public class ColorPoint extends Point {

	private int color;

	public ColorPoint(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!getClass().isInstance(o)) {
			return false;
		}
		ColorPoint cp = getClass().cast(o);
		return super.equals(o) && cp.color == this.color;
	}

}
