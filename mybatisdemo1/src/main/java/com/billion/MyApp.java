package com.billion;

import com.billion.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Billion
 * @create 2021-03-02 21:20
 */
public class MyApp {
	public static void main(String[] args) throws IOException {
		//1.主配置文件类路径
		String config = "mybatis.xml";
		//2.
		InputStream is = Resources.getResourceAsStream(config);
		//3.
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder =
				new SqlSessionFactoryBuilder();
		//4.
		SqlSessionFactory sqlSessionFactory =
				sqlSessionFactoryBuilder.build(is);
		//5.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//6.指定执行的SQL语句表示：SQL映射文件中的namespace + 标签id值
		String slqId = "com.billion.dao.StudentDao" + "." + "selectStudents";
		//7.
		List<Student> students = sqlSession.selectList(slqId);
		//8.
		for (Student student: students){
			System.out.println(student);
		}
		//9.
		sqlSession.close();
	}
}
