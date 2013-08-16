package com.sin90lzc.training.training_mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 从mybatis-config.xml文件获取元数据，由{@link SqlSessionFactoryBuilder#build(InputStream)}方法来生成{@linklin SqlSessionFactory}
 * @author tim
 *
 */
public class SampleSqlSessionFactory {
	private static SqlSessionFactory factory;

	private SampleSqlSessionFactory() {
	}

	/**
	 * 用于生成SqlSessionFactory的单例
	 * @return
	 */
	public static SqlSessionFactory getInstance() {
		if (factory == null) {
			InputStream is = null;
			try {
				is = Resources.getResourceAsStream("mybatis-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			factory = new SqlSessionFactoryBuilder().build(is);
		}
		return factory;
	}
}
