/**
 *
 * created on 2015年5月24日 上午10:04:03
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.db;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;
import org.springframework.transaction.annotation.Transactional;

import com.sin90lzc.spring.test.base.BaseTest;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年5月24日 上午10:04:03
 * 
 * @author Tim Leung
 */
@Sql(scripts={"before_class.sql"},config=@SqlConfig(transactionMode=TransactionMode.ISOLATED))
public class TransactionTest extends BaseTest {

	@Autowired
	private DAO dao;
	
	
	@Test(expected=Exception.class)
	public void testTransaction() throws Exception{
		dao.doSome();
	}
	
}
