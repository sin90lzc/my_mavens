/**
 *
 * created on 2015年5月24日 下午3:41:27
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年5月24日 下午3:41:27
 * 
 * @author Tim Leung
 */
@Service
public class DAO2Impl implements DAO2{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Throwable.class)
	public void save() throws Exception {
		jdbcTemplate.update("insert into before_class(id,name) values(?,?)", 101,"rain"); 
		
	}
	
}
