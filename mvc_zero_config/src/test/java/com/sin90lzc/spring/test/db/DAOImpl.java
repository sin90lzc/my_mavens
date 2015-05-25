/**
 *
 * created on 2015年4月25日 上午9:42:06
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年4月25日 上午9:42:06
 * 
 * @author Tim Leung
 */
@Service
//@Transactional
public class DAOImpl implements DAO {

	@Autowired
	private DAO2 dao2;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PlatformTransactionManager tm;
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void save() throws Exception{
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection conn)
//					throws SQLException {
//				PreparedStatement ps=conn.prepareStatement("insert into before_class(id,name) values(?,?)");
//				ps.setInt(1, id);
//				ps.setString(2, name);
//				return ps;
//			}
//		});
		TimeUnit.SECONDS.sleep(5);
		jdbcTemplate.update("insert into before_class(id,name) values(?,?)", 101,"rain"); 
		
		TimeUnit.SECONDS.sleep(5);
		
	}
	
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Throwable.class)
	public void doSome() throws Exception{
		jdbcTemplate.update("insert into before_class(id,name) values(?,?)", 100,"tim"); 
		
		save();
		if(true){
			throw new Exception("x");
		}
	}
}
