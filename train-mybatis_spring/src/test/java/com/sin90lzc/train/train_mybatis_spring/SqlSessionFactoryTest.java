package com.sin90lzc.train.train_mybatis_spring;

import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sin90lzc.mappers.DeptMapper;
import com.sin90lzc.training.training_bean.Dept;

public class SqlSessionFactoryTest extends TestCase {
	public static ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring-context.xml");
	private static SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context
			.getBean("sqlSessionFactory");

	public void testConfig() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			DeptMapper mapper = session.getMapper(DeptMapper.class);
			Set<Dept> depts = mapper.selectAllDept();
			Assert.assertNotNull(depts);
			Assert.assertTrue(depts.size() > 0);
			System.out.println(depts);
		} finally{
			session.close();
		}

	}
}
