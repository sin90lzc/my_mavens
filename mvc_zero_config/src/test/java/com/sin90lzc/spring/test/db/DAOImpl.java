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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
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
@Repository
public class DAOImpl implements DAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	@Transactional
	public void save(final int id, final String name) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps=conn.prepareStatement("insert into before_class(id,name) values(?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				return ps;
			}
		});
	}
}
