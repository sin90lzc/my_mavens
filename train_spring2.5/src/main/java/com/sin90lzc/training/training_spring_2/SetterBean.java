package com.sin90lzc.training.training_spring_2;

import org.springframework.beans.factory.InitializingBean;

/**
 * 用于测试spring的setter注入
 * @author Tim
 *
 */
public class SetterBean extends SimpleBean implements InitializingBean {
	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void afterPropertiesSet() throws Exception {
		container.getBeans().add(getBean());
	}

}
