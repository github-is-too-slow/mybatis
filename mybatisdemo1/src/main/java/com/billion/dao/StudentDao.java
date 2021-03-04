package com.billion.dao;

import com.billion.entity.Student;

import java.util.List;

/**
 * @author Billion
 * @create 2021-03-02 20:22
 */
public interface StudentDao {
	//查询返回多条记录
	List<Student> selectStudents();
	//插入单条记录
	int insertStudent(Student student);
}
