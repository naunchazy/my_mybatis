package com.exercise.service;

import java.util.List;
import java.util.Map;

import org.apache.catalina.User;

import com.exercise.pojo.po.Student;

public interface IStudentService {

	//查找所有学生
	List<Student> listStudents();
	//查找符合条件的学生
	Student selectStudentById(Integer id);
	List<Student> selectStudentLike1(String s);
	List<Student> selectStudentLike(Student student);
	List<Student> selectStudent(String name,String alias);
	//添加学生
	void insertStudent(Student stu);
	//修改学生信息
	void updateStudent(Student stu);
	//删除学生
	void deleteStudent(Integer id);
}
