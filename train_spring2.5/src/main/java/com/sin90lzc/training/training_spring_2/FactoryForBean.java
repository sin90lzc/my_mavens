package com.sin90lzc.training.training_spring_2;

/**
 * 工厂方式生成Bean
 * @author Tim
 *
 */
public class FactoryForBean {
	public static Bean createConstructorBean() {
		return new ConstructorBean("constructorBean:createByFactory", new Cup());
	}

	public static Bean createSetterBean() {
		Cup cup = new Cup();
		SetterBean bean = new SetterBean();
		bean.setBeanName("setterBean:createByFactory");
		bean.setContainer(cup);
		return bean;
	}
}
