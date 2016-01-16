/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sin90lzc.transiaction.BusinessTransiaction;
import com.sin90lzc.transiaction.BusinessTransiactionManager;

/**
 * copyright 
 * 
 * all right reserved.
 * 
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
		BusinessTransiactionManager.addBusinessTransiaction(new TestBusinessTransiaction("tim"));
	}
	
	
	static class TestBusinessTransiaction extends BusinessTransiaction{

		private String name;
		TestBusinessTransiaction(String name){
			this.name=name;
		}
		/**
		 * 
		 * override by Tim Leung
		 **/
		@Override
		public void doAfterCommit() {
			System.out.println(name+" commit!");
		}

		/**
		 * 
		 * override by Tim Leung
		 **/
		@Override
		public void doAfterRollBack() {
			System.out.println(name+" rollback!");
		}
		
	}
	
}
