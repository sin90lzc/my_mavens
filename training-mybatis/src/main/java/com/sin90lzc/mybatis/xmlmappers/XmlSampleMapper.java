package com.sin90lzc.mybatis.xmlmappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.sin90lzc.training.training_bean.Category;
import com.sin90lzc.training.training_bean.Dept;
import com.sin90lzc.training.training_bean.Emp;

public interface XmlSampleMapper {
	public int selectDeptId(int dd);
	public Dept selectDept(int id);
	public void insertDeptAutoKey(String name);
	public void insertDeptSelectKey(Dept dept);
	public void deleteDept(int id);
	
	@Select("select max(id) from dept")
	public int selectDeptMaxId();
	
	public int selectCountDept();
	
	public Set<Dept> selectAllDept();
	
	public List<Emp> selectEmp();
	
	public Emp selectEmpById(int id);
	
	public List<Category> selectAllCategory();
	public Category selectCategoryById(int id);
	public Set<Category> selectCategoryChildren(int parentId);
	
}
