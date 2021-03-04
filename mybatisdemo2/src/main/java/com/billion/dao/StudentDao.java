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
	//查询返回单个值
	int selectCount();

	//使用@Param传递参数
	Student selectOne(@Param("myname") String name, @Param("myage") Integer age);

	//使用java对象传递参数
	Student selectOneByObj(Student student);

	//按照位置传递参数
	Student selectOneByPos(String name, Integer age);

	//Map集合传递参数
	Student selectOneByMap(Map<String, Object> params);

	//使用别名封装查询结果
	Student selectOneByAlias(Map<String, Object> params);

	//使用Map封装查询结果，只适用于单条记录
	Map<Object, Object> selectMap(Student student);

	//通过resultMap封装结果
	MyStudent selectByResultMap(Student student);

	//通过别名解决字段和属性名不一致
	MyStudent selectByAlias(Student student);

	//模糊查询
	List<Student> selectByLike(String likeName);
}
