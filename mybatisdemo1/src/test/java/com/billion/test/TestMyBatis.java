package com.billion.test;

import com.billion.dao.StudentDao;
import com.billion.dao.impl.StudentDaoImpl;
import com.billion.entity.Student;
import com.billion.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Billion
 * @create 2021-03-03 11:16
 */
public class TestMyBatis {
	StudentDao studentDao = new StudentDaoImpl();

	@Test
	public void testSelectList() throws IOException {
		List<Student> students = studentDao.selectStudents();
		students.forEach(student -> {
			System.out.println(student);
		});
	}

	@Test
	public void testInsert() throws IOException {
		int nums = studentDao.insertStudent(new Student(200202, "盾山", "dunshan@qq.com", 20));
		System.out.println("nums = " + nums);
	}

	//使用Mybatis的动态代理
	@Test
	public void testSelectList2() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Student> students = dao.selectStudents();
		sqlSession.close();
		students.forEach(student -> {
			System.out.println(student);
		});
	}

	//使用Mybatis的动态代理
	@Test
	public void testInsert2() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		int nums = dao.insertStudent(new Student(200203, "鲁班大师", "lubandashi@qq.com", 20));
		sqlSession.commit();
		sqlSession.close();
		System.out.println("nums = " + nums);
	}
}
