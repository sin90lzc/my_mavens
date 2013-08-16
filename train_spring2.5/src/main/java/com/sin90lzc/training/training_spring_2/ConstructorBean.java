package com.sin90lzc.training.training_spring_2;

/**
 * 用于测试spring的构造器注入
 * @author Tim
 *
 */
public class ConstructorBean extends SimpleBean {
	private String beanName;

	public ConstructorBean(String beanName, Container container) {
		this.setBeanName(beanName);
		setContainer(container);
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void init() {
		container.getBeans().add(getBean());
	}

}
