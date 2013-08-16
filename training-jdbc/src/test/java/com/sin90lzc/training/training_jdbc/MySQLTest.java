package com.sin90lzc.training.training_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import junit.framework.Assert;

public class MySQLTest extends BaseTestForJdbc {
	private Connection conn;
	private static final String QUERY = "SELECT * from emp where name=?";
	static Logger logger = Logger.getLogger("mysql");
	static {
		try {
			Class.forName(props.getProperty("mysql.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setUp() throws SQLException {
		logger.debug("enter setup");
		conn = DriverManager.getConnection(props.getProperty("mysql.url"),
				props.getProperty("mysql.username"),
				props.getProperty("mysql.password"));
	}

	public void testQuery() throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(QUERY);
		ps.setString(1, "陈小小");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int job_id = rs.getInt("job_id");
			double sal = rs.getDouble("sal");
			Date hire = rs.getDate("hire_date");
			int manager = rs.getInt("manager");
			Assert.assertEquals(11, id);
			Assert.assertEquals("陈小小", name);
			Assert.assertEquals(8, job_id);
			Assert.assertEquals(6000D, sal);
			Assert.assertEquals("2012-04-21", hire.toString());
			// logger.debug(hire);
			Assert.assertEquals(2, manager);
		}

	}

	public void destroy() throws Exception {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
}
