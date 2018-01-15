package com.exercise.mapper;

import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.exercise.pojo.po.Student;
import com.exercise.service.IStudentService;
import com.exercise.service.impl.StudentServiceImpl2;


public class StudentMapperTest2 {

	IStudentService studentService2;
	@Before
	public void init(){
		studentService2=new StudentServiceImpl2();
	}
	@Test
	public void testListStudents() throws IOException{
		List<Student> list = studentService2.listStudents();
		for (Student student : list) {
			System.out.println(student.getId()+","+student.getName());
		}
	}
	/*结果：【因为加入了日志包log4j和日志接口slf4j，且将调试级别定为debug，所以能显示出相关信息】
	 * DEBUG [main] - Logging initialized using 'class org.apache.ibatis.logging.commons.JakartaCommonsLoggingImpl' adapter.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - Opening JDBC Connection
	* DEBUG [main] - Created connection 415186196.
	* DEBUG [main] - Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@18bf3d14]
	* DEBUG [main] - ==>  Preparing: select * from student 
	* DEBUG [main] - ==> Parameters: 
	* DEBUG [main] - <==      Total: 10
	* DEBUG [main] - Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@18bf3d14]
	* DEBUG [main] - Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@18bf3d14]
	* DEBUG [main] - Returned connection 415186196 to pool.
	0,Fenny
	1,admin
	2,dispatcher
	3,tom
	4,jack
	5,jim
	6,tonny
	7,Jenny
	8,Fenny
	9,minus*/
	@Test
	public void testSelectStudentById() throws IOException{
		Student student = studentService2.selectStudentById(3);
		System.out.println(student.getId()+","+student.getName());
	}
	@Test
	public void testselectStudentLike(){
		Student student=new Student();
		student.setName("j");
		List<Student> list=studentService2.selectStudentLike(student);
		for (Student stu : list) {
			System.out.println(stu.getId()+","+stu.getName());
		}
	}
	/*结果：
	* DEBUG [main] - Logging initialized using 'class org.apache.ibatis.logging.commons.JakartaCommonsLoggingImpl' adapter.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - PooledDataSource forcefully closed/removed all connections.
	* DEBUG [main] - Opening JDBC Connection
	* DEBUG [main] - Created connection 1361289747.
	* DEBUG [main] - Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@5123a213]
	* DEBUG [main] - ==>  Preparing: select * from Student where name like '%j%' 
	* DEBUG [main] - ==> Parameters: 
	* DEBUG [main] - <==      Total: 3
	* DEBUG [main] - Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@5123a213]
	* DEBUG [main] - Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@5123a213]
	* DEBUG [main] - Returned connection 1361289747 to pool.
	4,jack
	5,jim
	7,Jenny*/
	
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
		studentService2.insertStudent(stu);
	}
	@Test
	public void testUpdateStudent(){
		Student stu=new Student();
		stu.setId(10);
		stu.setName("kevin");
		stu.setAlias("VIP用户");
		studentService2.updateStudent(stu);
	}
	@Test
	public void testDeleteStudent(){
		studentService2.deleteStudent(10);
	}
}
