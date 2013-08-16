package com.sin90lzc.training.training_spring_2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TestTemplate extends TestCase {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "dao_template.xml", "datasources.xml" });
	private static final String QUERY_EMP = "select * from emp where sal>? and sal<?";
	private static final String QUERY_COUNT = "select count(*) from emp where sal>? and sal<?";
	private static final String NAMED_QUERY_EMP = "select * from emp where sal>:minsal and sal>maxsal";
	private static final String NAMed_QUERY_COUNT = "select count(*) from emp where sal>:minsal and sal<maxsal";

	public void testJDBCTemplate() {
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
		Object[] args = new Object[] { 4000, 5000 };
		// template.queryForMap("", args)
		Object result = template.query(QUERY_EMP, args,
				new EmpResultSetExtractor());
		int count = template.queryForInt(QUERY_COUNT, args);
		Assert.assertTrue(result instanceof List);
		Assert.assertEquals(count, ((List<Emp>) result).size());
	}
	

	static class EmpResultSetExtractor implements ResultSetExtractor {
		public EmpResultSetExtractor() {
		}

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			List<Emp> list = new ArrayList<Emp>();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("id"));
				emp.setJob(new Job(rs.getInt("job_id")));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setLeaveDate(rs.getDate("leave_date"));
				emp.setName(rs.getString("name"));
				emp.setManager(new Emp(rs.getInt("manager")));
				list.add(emp);
			}
			return list;
		}

	}
}
