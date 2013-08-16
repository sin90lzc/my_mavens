package com.sin90lzc.training.training_spring_2;

import java.util.ArrayList;
import java.util.List;

public class Cup implements Container {

	private List<Bean> beans=new ArrayList<Bean>();

	public void setBeans(List<Bean> beans) {
		this.beans = beans;
	}

	public List<Bean> getBeans() {
		return beans;
	}

}
