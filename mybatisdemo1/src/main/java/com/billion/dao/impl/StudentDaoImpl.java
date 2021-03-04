package com.billion.dao.impl;

import com.billion.dao.StudentDao;
import com.billion.entity.Student;
import com.billion.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Billion
 * @create 2021-03-03 12:27
 */
public class StudentDaoImpl implements StudentDao{
	@Override
	public List<Student> selectStudents() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		String sqlId = "com.billion.dao.StudentDao" + "." + "selectStudents";
		List<Student> students = sqlSession.selectList(sqlId);
		sqlSession.close();
		return students;
	}

	@Override
	public int insertStudent(Student student) {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		String sqlId = "com.billion.dao.StudentDao" + "." + "insertStudent";
		int nums = sqlSession.insert(sqlId, student);
		sqlSession.commit();
		sqlSession.close();
		return nums;
	}
}
