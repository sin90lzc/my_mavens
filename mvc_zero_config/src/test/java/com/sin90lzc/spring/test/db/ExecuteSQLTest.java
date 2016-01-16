/**
 *
 * created on 2015年4月19日 下午6:07:39
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.db;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

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
 * @Rollback 注解只对在@Transactional范围内的语句有效！！！！
 * 
 * @Before和@After都在事务范围内，而@BeforeTransaction和@AfterTransaction不在事务范围内。
 * 
 * @author Tim Leung
 */
@Sql(scripts={"before_class.sql"},config=@SqlConfig(transactionMode=TransactionMode.ISOLATED))
public class ExecuteSQLTest extends BaseTest{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DAO dao;
	
	@Before
	public void before(){
		int count=JdbcTestUtils.countRowsInTable(jdbcTemplate, "before_class");
		Assert.assertEquals(2, count);
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void test(){
		JdbcTestUtils.deleteFromTableWhere(jdbcTemplate, "before_class", "id=?", 1);
		int count=JdbcTestUtils.countRowsInTable(jdbcTemplate, "before_class");
		Assert.assertEquals(1, count);
	}
	
	@After
	public void after(){
		int count=JdbcTestUtils.countRowsInTable(jdbcTemplate, "before_class");
		Assert.assertEquals(1, count);
	}
	
	@AfterTransaction
	public void afterTransaction(){
		int count=JdbcTestUtils.countRowsInTable(jdbcTemplate, "before_class");
		Assert.assertEquals(2, count);
	}
}