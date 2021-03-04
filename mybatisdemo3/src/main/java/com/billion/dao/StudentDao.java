package com.billion.dao;

import com.billion.entity.MyStudent;
import com.billion.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Billion
 * @create 2021-03-02 20:22
 */
public interface StudentDao {
	//动态SQL之if标签
	List<Student> selectOneByIf(Student student);

	//动态SQL之where标签
	List<Student> selectOneByWhere(Student student);

	//动态SQL之foreach标签，直接传入id值数组
	List<Student> selectOneByForeach1(Integer[] ids);

	//动态SQL之foreach标签，传入对象列表
	List<Student> selectOneByForeach2(List<Student> students);

	//通过PageHelper实现分页功能，在测试代码中加入PageHelper.startPage(1, 3);
	List<Student> selectAllByPageHelper();
}
