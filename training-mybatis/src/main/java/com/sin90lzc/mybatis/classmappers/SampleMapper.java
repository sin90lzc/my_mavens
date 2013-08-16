package com.sin90lzc.mybatis.classmappers;

import org.apache.ibatis.annotations.Select;

import com.sin90lzc.training.training_bean.Emp;

public interface SampleMapper {
	@Select("select id,name,sal,job_id as job,hire_date as hireDate,leave_date as leaveDate from emp where id=#{id}")
	public Emp selectEmp(int id);
}
