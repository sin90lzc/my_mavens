package com.sin90lzc.training.training_spring_2;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 测试使用{@link BeanFactory}的依赖注入<br />
 * <br />
 * 
 * 与{@link ApplicationContextTest}对比，BeanFactory不支持BeanFactoryPostProcessor
 * 
 * @author tim
 * 
 */
public class BeanFactoryTest extends TestCase {
	private static final BeanFactory factory = new XmlBeanFactory(
			new ClassPathResource("ApplicationContext_beans.xml"));

	public void testLoad() {
		Object obj = factory.getBean("cup");
		Assert.assertTrue(obj instanceof Container);
		Assert.assertTrue(obj instanceof Cup);
		Cup cup = (Cup) obj;
		// 与ApplicationContext不一样，它不支持BeanFactoryPostProcessor
		Assert.assertEquals(0, cup.getBeans().size());

		Cup listCup = (Cup) factory.getBean("listCup");
		Assert.assertEquals(2, listCup.getBeans().size());

		SetterBean sb1 = (SetterBean) factory.getBean("setterBean");
		SetterBean sb2 = (SetterBean) factory.getBean("setterBean");
		Assert.assertNotSame(sb1, sb2);

		ConstructorBean cb1 = (ConstructorBean) factory
				.getBean("constructorBean");
		ConstructorBean cb2 = (ConstructorBean) factory
				.getBean("constructorBean");
		Assert.assertSame(cb1, cb2);

		ConstructorBean cbFromFactory = (ConstructorBean) factory
				.getBean("constructorBeanFromFactory");
		Assert.assertNotNull(cbFromFactory);
		SetterBean sbFromFactory = (SetterBean) factory
				.getBean("setterBeanFromFactory");
		Assert.assertNotNull(sbFromFactory);

	}
}
