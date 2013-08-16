package com.sin90lzc.training.training_spring_2;

import java.util.Calendar;
import java.util.Properties;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试使用{@link ApplicationContext}的依赖注入、方法注入、属性编辑器<br />
 * <br />
 * 
 * 各个Bean的说明：<br />
 * simpleBean：是抽象Bean，它实现了{@link Bean}接口<br />
 * constructorBean：继承了{@link SimpleBean}，它通过构造器
 * {@link ConstructorBean#ConstructorBean(String, Container)}实例化，并有一个初始化方法
 * {@link ConstructorBean#init()}方法，由Spring调用，它的作用是向cup填充自己。<br />
 * <br />
 * setterBean：继承了{@link SimpleBean}，它通过Setter方法
 * {@link SetterBean#setBeanName(String)}
 * {@link SetterBean#setContainer(Container)}填充属性，另外它还实现了
 * {@link InitializingBean}，由Spring调用，向cup填充自己<br />
 * <br />
 * cup：由默认构造器实例化，它被注入到constructorBean和setterBean的Container属性，
 * 由constructorBean和setterBean在初始化时向其beans属性注入值。<br />
 * <br />
 * listCup：与cup一样，由类{@link Cup}创建。而它与cup不一样的是，它的beans属性是由spring注入。<br />
 * <br />
 * constructorBeanFromFactory和setterBeanFromFactory：都是通过工厂方法生成。 <br />
 * <br />
 * 任何一个Bean实现了{@link FactoryBean},那么通过容器获取该Bean的实例时,该实例是
 * {@link FactoryBean#getObject()}方法的返回值.
 * 
 * @author tim
 * 
 */
public class ApplicationContextTest extends TestCase {

	private final static ApplicationContext context = new ClassPathXmlApplicationContext(
			"ApplicationContext_beans.xml");

	public void testLoad() {
		Object obj = context.getBean("cup");
		Assert.assertTrue(obj instanceof Container);
		Assert.assertTrue(obj instanceof Cup);
		Cup cup = (Cup) obj;
		Assert.assertEquals(2, cup.getBeans().size());

		Cup listCup = (Cup) context.getBean("listCup");
		Assert.assertEquals(2, listCup.getBeans().size());

		SetterBean sb1 = (SetterBean) context.getBean("setterBean");
		SetterBean sb2 = (SetterBean) context.getBean("setterBean");
		Assert.assertNotSame(sb1, sb2);

		ConstructorBean cb1 = (ConstructorBean) context
				.getBean("constructorBean");
		ConstructorBean cb2 = (ConstructorBean) context
				.getBean("constructorBean");
		Assert.assertSame(cb1, cb2);

		ConstructorBean cbFromFactory = (ConstructorBean) context
				.getBean("constructorBeanFromFactory");
		Assert.assertNotNull(cbFromFactory);
		SetterBean sbFromFactory = (SetterBean) context
				.getBean("setterBeanFromFactory");
		Assert.assertNotNull(sbFromFactory);

	}

	/**
	 * 测试Spring的方法注入的两种方式：<br />
	 * 1.使用{@link MethodReplacer}替换已经有的方法&lt;replaced-method&gt;标签<br />
	 * 2.使用getter注入的方式&lt;lookup-method&gt;标签<br />
	 * 这两种方式都可以从beanForReplaceMethod中看到其实现
	 */
	public void testReplaceMethod() {
		BeanForReplaceMethod bean = (BeanForReplaceMethod) context
				.getBean("beanForReplaceMethod");
		Assert.assertEquals("message replaced", bean.printMessage());
		Assert.assertTrue(bean.getBean() instanceof SetterBean);
	}

	/**
	 * 测试Spring的自定义属性编辑器<br />
	 * Spring自带的属性编辑器还包括有：<br />
	 * {@link ClassEditor} {@link CustomDateEditor} {@link FileEditor}
	 * {@link LocalEditor} {@link StringArrayPropertyEditor}
	 * {@link StringTrimmerEditor} {@link URLEditor}
	 */
	public void testPropertyEditor() {
		SetPointBean sp = (SetPointBean) context.getBean("setPointBean");
		Assert.assertNotNull(sp.getPoint());
		Assert.assertEquals(7, sp.getPoint().getX());
		Assert.assertEquals(9, sp.getPoint().getY());
	}

	/**
	 * 测试Spring的属性外在化
	 * 
	 * @throws Exception
	 */
	public void testPlaceHolder() throws Exception {
		PlaceHolderBean bean = (PlaceHolderBean) context
				.getBean("placeHolderBean");
		Properties jdbc = new Properties();
		jdbc.load(ApplicationContextTest.class.getClassLoader()
				.getResourceAsStream("jdbc.properties"));
		Properties security = new Properties();
		security.load(ApplicationContextTest.class.getClassLoader()
				.getResourceAsStream("security.properties"));
		Assert.assertEquals(bean.getUrl(), jdbc.getProperty("oracle.url"));
		Assert.assertEquals(bean.getDriver(), jdbc.getProperty("oracle.driver"));
		Assert.assertEquals(bean.getUsername(),
				security.getProperty("username"));
		Assert.assertEquals(bean.getPassword(),
				security.getProperty("password"));
	}

	/**
	 * 测试由{@link FactoryBean}生成的Bean 任何一个Bean实现了{@link FactoryBean}
	 * ,那么通过容器获取该Bean的实例时,该实例是{@link FactoryBean#getObject()}方法的返回值.
	 */
	public void testFactoryBean() {
		Object obj = context.getBean("beanCreateFromFactoryBean");
		Assert.assertTrue(Calendar.class.isAssignableFrom(obj.getClass()));
	}
}
