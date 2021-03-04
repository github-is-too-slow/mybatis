package com.billion.test;

import com.billion.dao.StudentDao;
import com.billion.entity.MyStudent;
import com.billion.entity.Student;
import com.billion.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Billion
 * @create 2021-03-03 11:16
 */
public class TestMyBatis {

	@Test
	public void testSelectOneByIf() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student(1001, "", "lisi@qq.com", null);
		List<Student> students = dao.selectOneByIf(stu);
		System.out.println("students = " + students);
	}

	@Test
	public void testSelectOneByWhere() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student(1001, "李四", "lisi@qq.com", 18);
		List<Student> students = dao.selectOneByWhere(stu);
		System.out.println("students = " + students);
	}

	@Test
	public void selectOneByForeach1() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Integer[] ids = {1001, 1002, 1003};
		List<Student> students = dao.selectOneByForeach1(ids);
		System.out.println("students = " + students);
	}

	@Test
	public void selectOneByForeach2() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Student> stus = new ArrayList<>();
		stus.add(new Student(1001, null, null, null));
		stus.add(new Student(1002, null, null, null));
		stus.add(new Student(1003, null, null, null));
		List<Student> students = dao.selectOneByForeach2(stus);
		System.out.println("students = " + students);
	}

	@Test
	public void selectAllByPageHelper() throws IOException {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		PageHelper.startPage(2, 4);
		List<Student> students = dao.selectAllByPageHelper();
		System.out.println("students = " + students);
	}
}
