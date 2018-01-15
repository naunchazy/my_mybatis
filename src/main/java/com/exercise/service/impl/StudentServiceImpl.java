package com.exercise.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exercise.pojo.po.Student;
import com.exercise.service.IStudentService;

import util.DBUtil;

public class StudentServiceImpl implements IStudentService {

	
	SqlSessionFactory sqlSessionFactory;
	public StudentServiceImpl() {
		sqlSessionFactory=DBUtil.findSqlSession();
	}
	@Override
	public List<Student> listStudents() {
		SqlSession session=sqlSessionFactory.openSession();
		List<Student> list = session.selectList("com.exercise.mapper.StudentMapper.listStudents");
		//方法内的参数由映射配置文件的namespace【即：接口】和sql语句相应的id【即：sql对应的方法】组成的
		session.close();
		return list;
	}
	@Override
	public Student selectStudentById(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		Student stu= session.selectOne("com.exercise.mapper.StudentMapper.selectStudentById", id);
		//方法内的第一个参数由映射配置文件的namespace和sql语句相应的id组成的，第二个参数为方法所需参数
		session.close();
		return stu;
	}
	
	
	@Override
	public List<Student> selectStudentLike1(String s) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Student> list=null;
		list=session.selectList("com.exercise.mapper.StudentMapper.selectStudentLike", s);
		session.rollback();
		session.close();
		return list;
	}
	@Override
	public List<Student> selectStudentLike(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Student> list=null;
		list=session.selectList("com.exercise.mapper.StudentMapper.selectStudentLike", student);
		session.close();
		return list;
	}
	@Override
	public List<Student> selectStudent(String name, String alias) {
		/*SqlSession session = sqlSessionFactory.openSession();
		session.selectMap("com.exercise.dao.IStudentDao.selectStudent", name, alias);
		*/return null;
	}

	@Override
	public void insertStudent(Student stu) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("com.exercise.mapper.StudentMapper.insertStudent", stu);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
	}
	
	@Override
	public void updateStudent(Student stu) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("com.exercise.mapper.StudentMapper.updateStudent", stu);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteStudent(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			session.delete("com.exercise.mapper.StudentMapper.deleteStudent", 10);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
	}

}
