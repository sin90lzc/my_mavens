package com.sin90lzc.training.training_mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sin90lzc.training.training_bean.Job;

public class JobTypeHandler implements TypeHandler<Job> {

	@Override
	public Job getResult(ResultSet rs, String columnName) throws SQLException {
		int job_id = rs.getInt(columnName);
		System.out.println("enter");
		return new Job(job_id);
	}

	@Override
	public Job getResult(ResultSet rs, int columnIndex) throws SQLException {
		int job_id = rs.getInt(columnIndex);
		System.out.println("enter");
		return new Job(job_id);
	}

	@Override
	public Job getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		int job_id = cs.getInt(columnIndex);
		System.out.println("enter");
		return new Job(job_id);
	}

	@Override
	public void setParameter(PreparedStatement ps, int index, Job parameter,
			JdbcType jdbcType) throws SQLException {
		ps.setObject(index, parameter);
	}

}
