package com.sin90lzc.training.training_spring_2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 该测试用于测试JDBC数据源,C3P0数据源,DBCP数据源
 * @author Tim
 *
 */
public class TestDataSource extends TestCase {

	private static final String SQL_QUERY="select * from dept where name=?";
	private static final ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "datasources.xml" });

	public void setUp() {

	}
	
	/**
	 * 测试jdbc数据源
	 * @throws Exception
	 */
	public void testJDBC() throws Exception{
		DataSource ds=(DataSource)context.getBean("dataSource_jdbc");
		getTestDataSource(ds);
		
	}
	
	/**
	 * 测试C3P0数据源
	 * @throws Exception
	 */
	public void testC3P0() throws Exception{
		DataSource ds=(DataSource)context.getBean("dataSource_C3P0");
		getTestDataSource(ds);
	}
	
	/**
	 * 测试DBCP数据源
	 * @throws Exception
	 */
	public void testDBCP() throws Exception{
		DataSource ds=(DataSource)context.getBean("dataSource_DBCP");
		getTestDataSource(ds);
	}
	
	
	private void getTestDataSource(DataSource ds) throws Exception{
		Connection conn=ds.getConnection();
		PreparedStatement ps=conn.prepareStatement(SQL_QUERY);
		ps.setString(1, "财务部");
		ResultSet rs=ps.executeQuery();
		Assert.assertEquals(true, rs.next());
		conn.close();
	}
}
