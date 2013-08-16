package com.sin90lzc.training.training_spring_2;

/**
 * 每个{@link Bean}的实现都是返回它自己
 * 每个{@link Bean}都是放在容器内{@link Container}
 * @author Tim
 *
 */
public abstract class SimpleBean implements Bean {

	protected Container container;

	public Bean getBean() {
		return this;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}
}
