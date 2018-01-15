package com.exercise.mapper;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.exercise.pojo.po.Student;
import com.exercise.service.IStudentService;
import com.exercise.service.impl.StudentServiceImpl;

public class StudentMapperTest {

	IStudentService studentService;
	@Before
	public void init(){
		studentService=new StudentServiceImpl();
	}
	@Test
	public void testListStudents() throws IOException{
		List<Student> list = studentService.listStudents();
		for (Student student : list) {
			System.out.println(student.getId()+","+student.getName());
		}
	}
	@Test
	public void testSelectStudentById() throws IOException{
		Student student = studentService.selectStudentById(3);
		System.out.println(student.getId()+","+student.getName());
	}
	@Test
	public void testselectStudentLike(){
		Student student=new Student();
		student.setName("j");
		List<Student> list=studentService.selectStudentLike(student);
		for (Student stu : list) {
			System.out.println(stu.getId()+","+stu.getName());
		}
	}
	/*@Test
	public void testselectStudentLike1(){
		List<Student> list = studentService.selectStudentLike1("j");
		for (Student stu : list) {
			System.out.println(stu.getId()+","+stu.getName());
		}
	}*/
	/*@Test
	public void testSelectStudent() throws IOException{
		List<Student> list = studentService.selectStudent("tonny","用户");
		for (Student student : list) {
			System.out.println(student.getId()+","+student.getName());
		}
	}*/
	@Test
	public void testInsertStudent(){
		Student stu=new Student();
		stu.setId(10);
		stu.setName("kevin");
		stu.setAlias("用户");
		studentService.insertStudent(stu);
	}
	@Test
	public void testUpdateStudent(){
		Student stu=new Student();
		stu.setId(10);
		stu.setName("kevin");
		stu.setAlias("VIP用户");
		studentService.updateStudent(stu);
	}
	@Test
	public void testDeleteStudent(){
		studentService.deleteStudent(10);
	}
}
