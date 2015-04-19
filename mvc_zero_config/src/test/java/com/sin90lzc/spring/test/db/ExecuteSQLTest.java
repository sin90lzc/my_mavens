/**
 *
 * created on 2015年4月19日 下午6:07:39
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.db;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.sin90lzc.spring.test.base.BaseTest;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年4月19日 下午6:07:39
 * 
 * 测试在class级别和method级别使用@Sql，可以看出，method级别的@Sql会覆盖class级别的@Sql配置
 * 
 * 
 * @author Tim Leung
 */
@Sql(scripts={"before_class.sql"})
public class ExecuteSQLTest extends BaseTest{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void before(){
		int count=JdbcTestUtils.countRowsInTable(jdbcTemplate, "before_class");
		Assert.assertEquals(2, count);
	}
	
	@Test
	//@Sql(scripts="before_test.sql")
	public void test(){
		int count=JdbcTestUtils.countRowsInTable(jdbcTemplate, "before_class");
		Assert.assertEquals(2, count);
	}
}
