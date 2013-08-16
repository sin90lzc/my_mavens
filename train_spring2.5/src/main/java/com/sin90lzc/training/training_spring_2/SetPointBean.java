package com.sin90lzc.training.training_spring_2;

/**
 * 用于测试Spring的属性编辑器功能
 * @author Tim
 *
 */
public class SetPointBean extends SimpleBean{
	private Point point;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	

}
