package com.billion.test;

import com.billion.dao.StudentDao;
import com.billion.entity.MyStudent;
import com.billion.entity.Student;
import com.billion.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Billion
 * @create 2021-03-03 11:16
 */
public class TestMyBatis {
	@Test
	public void testSelectCount() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		int nums = dao.selectCount();
		System.out.println("nums = " + nums);
	}

	@Test
	public void testSelectOne() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student student = dao.selectOne("李四", 18);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectOneByObj() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student(1001, "李四", "lisi@qq.com", 18);
		Student student = dao.selectOneByObj(stu);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectOneByPos() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student student = dao.selectOneByPos("李四", 18);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectOneByMap() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Map<String, Object> params = new HashMap<>();
		params.put("name", "李四");
		params.put("age", 18);
		Student student = dao.selectOneByMap(params);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectOneByAlias() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Map<String, Object> params = new HashMap<>();
		params.put("name", "李四");
		params.put("age", 18);
		Student student = dao.selectOneByAlias(params);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectMap() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student(1001, "李四", "lisi@qq.com", 18);
		Map<Object, Object> student = dao.selectMap(stu);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectByResultMap() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student(1001, "李四", "lisi@qq.com", 18);
		MyStudent student = dao.selectByResultMap(stu);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectByAlias() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student(1001, "李四", "lisi@qq.com", 18);
		MyStudent student = dao.selectByAlias(stu);
		System.out.println("student = " + student);
	}

	@Test
	public void testSelectByLike() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		String likeName = "%刘%";
		List<Student> students = dao.selectByLike(likeName);
		System.out.println("students = " + students);
	}
}
