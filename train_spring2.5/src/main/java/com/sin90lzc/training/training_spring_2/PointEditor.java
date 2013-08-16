package com.sin90lzc.training.training_spring_2;

import java.beans.PropertyEditorSupport;

/**
 * 针对{@link Point}的属性编辑器
 * 
 * @author tim
 * 
 */
public class PointEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] data = text.split(",");
		if (data.length != 2) {
			throw new RuntimeException();
		}
		setValue(new Point(Integer.parseInt(data[0].trim()),
				Integer.parseInt(data[1].trim())));
	}
}
