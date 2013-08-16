package com.sin90lzc.training.training_mybatis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.sin90lzc.mybatis.classmappers.SampleMapper;
import com.sin90lzc.mybatis.xmlmappers.XmlSampleMapper;
import com.sin90lzc.training.training_bean.Category;
import com.sin90lzc.training.training_bean.Dept;
import com.sin90lzc.training.training_bean.Emp;
import com.sin90lzc.training.training_bean.Job;

public class SampleTest extends TestCase {

	private static Logger logger = Logger.getLogger(SampleTest.class);

	/**
	 * 使用直接xml方式调用查询
	 */
	public void testXMLMapper() {
		warnMethod("testXMLMapper");
		SqlSession session = SampleSqlSessionFactory.getInstance()
				.openSession();
		try {
			Emp emp = session
					.<Emp> selectOne(
							"com.sin90lzc.mybatis.xmlmappers.XmlSampleMapper.selectSimpleEmp",
							1);
			Assert.assertNotNull(emp);
			logger.warn(emp.getName());
			logger.warn(emp.getHireDate());
			//Assert.assertNotNull(emp.getJob());
			logger.warn(emp.getJob());

			XmlSampleMapper mapper = session.getMapper(XmlSampleMapper.class);
			Assert.assertEquals(1, mapper.selectDeptId(1));
		} finally {
			session.close();
		}
	}
	
	/**
	 * 测试使用class映射来调用查询
	 */
	public void testClassMapper() {
		warnMethod("testClassMapper");
		SqlSession session = SampleSqlSessionFactory.getInstance()
				.openSession();
		try {
			SampleMapper mapper = session.getMapper(SampleMapper.class);
			Emp emp = mapper.selectEmp(2);
			Assert.assertNotNull(emp);
			logger.warn(emp.getName());
			logger.warn(emp.getHireDate());
			// Assert.assertNotNull(emp.getJob());
			logger.warn(emp.getJob());
		} finally {
			session.close();
		}
	}
	
	/**
	 * 测试增删查改
	 */
	public void testCRUD(){
		warnMethod("testCRUD");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			mapper.insertDeptAutoKey("insertAutoKey");
			logger.warn("autoKey:"+mapper.selectDeptMaxId());
			Dept dept=new Dept();
			dept.setName("abc");
			mapper.insertDeptSelectKey(dept);
			logger.warn("selectKey:"+mapper.selectDeptMaxId());
			mapper.deleteDept(4);
			session.commit();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 测试flushCache属性的作用，它可以清除select语句的查询缓存。
	 * 不知道为什么在这个测试中无效？？
	 */
	public void testFlushCache(){
		warnMethod("testFlushCache");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			Collection<Dept> ds=mapper.selectAllDept();
			logger.warn(ds.size());
			mapper.insertDeptAutoKey("tim");
			mapper.selectDeptId(4);
			logger.warn(ds.size());
			mapper.deleteDept(4);
		}finally{
			session.close();
		}
	}
	
	/**
	 * 测试一下简单的resultMap配置
	 */
	public void testSimpleResultMap(){
		warnMethod("testSimpleResultMap");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			Dept dept=mapper.selectDept(4);
			Assert.assertNotNull(dept);
			Assert.assertEquals(4, dept.getId());
		}finally{
			session.close();
		}
	}
	
	/**
	 *  测试结果是一个集合的情况
	 */
	public void testCollectionResult(){
		warnMethod("testCollectionResult");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			Collection<Dept> ds=mapper.selectAllDept();
			Assert.assertNotNull(ds);
			logger.warn(ds.getClass().getName());
			logger.warn(ds);
		}finally{
			session.close();
		}
	}
	
	/**
	 * 使用resultMap方式映射结果集
	 */
	public void testSelectAllEmp(){
		warnMethod("testSelectAllEmp");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			Collection<Emp> emps=mapper.selectEmp();
			for(Emp e:emps){
				Assert.assertNotNull(e);
				Assert.assertNotNull(e.getJob());
				Assert.assertTrue(e.getJob() instanceof Job);
				Assert.assertNotNull(e.getJob().getDept());
				if(e.getId()==4){
					logger.warn(e.getManager().getName());
					logger.warn(e.getManager().getManager().getName());
				}
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * 使用association联合查询时使用select方式可以实现递归查询
	 */
	public void testSelectEmpById(){
		warnMethod("testSelectEmpById");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			Emp emp=mapper.selectEmpById(8);
			//Assert.assertNotNull(emp.getManager());
			//Assert.assertNotNull(emp.getManager().getManager());
			logger.warn(emp.getManager().getName());
			logger.warn(emp.getManager().getManager().getName());
		}finally{
			session.close();
		}
	}
	
	private void warnMethod(String methodName){
		logger.warn("\n--------------------"+methodName+"-----------------------");
	}
	
	/**
	 * 使用递归的方式查询所有的Category
	 */
	public void testSelectAllCategory(){
		warnMethod("testSelectAllCategory");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			
			Collection<Category> categories=mapper.selectAllCategory();
			
			Assert.assertNotNull(categories);
			logger.warn(categories.getClass().getName());
			logger.warn(categories.size());
			Iterator<Category> it=categories.iterator();
			while(it.hasNext()){
				Category c=it.next();
				logger.warn(c.getName()+"'s parent:"+(c.getParent()!=null?c.getParent().getName():"null"));
				logger.warn(c.getName()+"'s children:"+childrenStringArray(c));
			}
		}finally{
			session.close();
		}
	}
	
	/**
	 * 只查某个id的Category一样可以实现递归
	 */
	public void testSelectCategoryById(){
		warnMethod("testSelectCategoryById");
		SqlSession session=SampleSqlSessionFactory.getInstance().openSession();
		try{
			XmlSampleMapper mapper=session.getMapper(XmlSampleMapper.class);
			Category c=mapper.selectCategoryById(1);
			logger.warn(c.getName()+"'s children:"+childrenStringArray(c));		
		}finally{
			session.close();
		}
		
	}
	
	
	private List<Category> addAll(Category c){
		List<Category> list=new ArrayList<Category>();
		if(c.getChildren()!=null && c.getChildren().size()!=0){
			list.addAll(c.getChildren());
			for(Category cc:c.getChildren()){
				list.addAll(addAll(cc));
			}
		}
		return list;
	}
	
	private String childrenStringArray(Category c){
		StringBuffer sb=new StringBuffer("[");
		List<Category> cs=addAll(c);
		for(Category cc:cs){
			sb.append(cc.getName());
			sb.append(",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	
	
}
