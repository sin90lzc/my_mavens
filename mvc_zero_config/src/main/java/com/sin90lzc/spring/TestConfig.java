/**
 *
 * created on 2015��4��19�� ����2:46:00
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015��4��19�� ����2:46:00
 * 
 * ��ApplicationContext���ڵ�Ԫ����
 * 
 * @author Tim Leung
 */
@Configuration
@Profile("test")
public class TestConfig {

	@Bean()
	public DataSource dataSource() {
		Properties p=new Properties();
		p.put("username", "test");
		p.put("password", "123");
		p.put("url", "jdbc:mysql://192.168.1.12:3306/test");
		p.put("driverClassName","com.mysql.jdbc.Driver");
		BasicDataSource ds=null;
		try {
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//��������Ԫ���Ե�ʱ��ִ��SQL�����ַ�ʽ���Ǻܺð�
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/test.sql"));
		populator.execute(ds);
		return ds;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate t=new JdbcTemplate(dataSource);
		return t;
	}
	
}
