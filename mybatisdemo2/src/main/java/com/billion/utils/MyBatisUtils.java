package com.billion.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Billion
 * @create 2021-03-03 11:53
 */
public class MyBatisUtils {
	//重量级对象，创建耗时，只创建一次即可
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		try {
			String config = "mybatis.xml";
			InputStream is = Resources.getResourceAsStream(config);
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//获取非自动提交事务的SqlSession对象
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}

	//获取自动提交事务的SqlSession对象
	public static SqlSession getSqlSession(boolean isAutoCommit){
		return sqlSessionFactory.openSession(isAutoCommit);
	}
}
