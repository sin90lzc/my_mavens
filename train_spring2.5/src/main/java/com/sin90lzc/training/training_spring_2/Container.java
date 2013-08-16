package com.sin90lzc.training.training_spring_2;

import java.util.List;

public interface Container {
	public void setBeans(List<Bean> beans);

	public List<Bean> getBeans();
}
