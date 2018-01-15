package com.exercise.service;

import java.util.List;
import java.util.Map;

import org.apache.catalina.User;

import com.exercise.pojo.po.Student;

public interface IStudentService {

	//��������ѧ��
	List<Student> listStudents();
	//���ҷ���������ѧ��
	Student selectStudentById(Integer id);
	List<Student> selectStudentLike1(String s);
	List<Student> selectStudentLike(Student student);
	List<Student> selectStudent(String name,String alias);
	//���ѧ��
	void insertStudent(Student stu);
	//�޸�ѧ����Ϣ
	void updateStudent(Student stu);
	//ɾ��ѧ��
	void deleteStudent(Integer id);
}
