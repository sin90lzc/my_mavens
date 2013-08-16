package com.sin90lzc.training.training_mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sin90lzc.training.training_bean.Dept;

public class DeptTypeHandler implements TypeHandler<Dept> {

	@Override
	public Dept getResult(ResultSet rs, String columnName) throws SQLException {
		return new Dept(rs.getInt(columnName));
	}

	@Override
	public Dept getResult(ResultSet rs, int columnIndex) throws SQLException {
		return new Dept(rs.getInt(columnIndex));
	}

	@Override
	public Dept getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return new Dept(cs.getInt(columnIndex));
	}

	@Override
	public void setParameter(PreparedStatement ps, int index, Dept parameter,
			JdbcType arg3) throws SQLException {
		ps.setObject(index, parameter);
	}

}
