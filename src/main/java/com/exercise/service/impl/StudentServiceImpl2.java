package com.exercise.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exercise.mapper.StudentMapper;
import com.exercise.pojo.po.Student;
import com.exercise.service.IStudentService;

import util.DBUtil;

public class StudentServiceImpl2 implements IStudentService{

	SqlSessionFactory sqlSessionFactory;
	public StudentServiceImpl2() {
		sqlSessionFactory=DBUtil.findSqlSession();
	}
	@Override
	public List<Student> listStudents() {
		SqlSession session=sqlSessionFactory.openSession();
		//��������JDK��̬����ʽ����IStudentDao�ӿڵ�ʵ������񣬼ȿ��Ե��øýӿڵ����з���
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		List<Student> list = mapper.listStudents();
		/*//����һ��
		*List<Student> list = session.selectList("com.exercise.dao.IStudentDao.listStudents");*/
		session.close();
		return list;
	}
	@Override
	public Student selectStudentById(Integer id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
//		��������
		Student stu = mapper.selectStudentById(id);
		/*//����һ��
		*Student stu= session.selectOne("com.exercise.dao.IStudentDao.selectStudentById", id);*/
		session.close();
		return stu;
	}
	
	
	@Override
	public List<Student> selectStudentLike1(String s) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
//		��������
		List<Student> list = mapper.selectStudentLike1(s);
		/*//����һ��
		 *List<Student> list=session.selectList("com.exercise.dao.IStudentDao.selectStudentLike", s);*/
		session.close();
		return list;
	}
	@Override
	public List<Student> selectStudentLike(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
//		��������
		List<Student> list = mapper.selectStudentLike(student);
		/*//����һ��
		*List<Student> list=session.selectList("com.exercise.dao.IStudentDao.selectStudentLike", student);*/
		session.close();
		return list;
	}
	@Override
	public List<Student> selectStudent(String name, String alias) {
//		SqlSession session = sqlSessionFactory.openSession();
//		session.selectMap("com.exercise.dao.IStudentDao.selectStudent", name, alias);
		return null;
	}

	@Override
	public void insertStudent(Student stu) {
		SqlSession session = sqlSessionFactory.openSession();
//		��������
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		try {
			mapper.insertStudent(stu);
			/*//����һ��
			*session.insert("com.exercise.dao.IStudentDao.insertStudent", stu);*/
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
//		��������
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		try {
			mapper.updateStudent(stu);
			/*//����һ��
			 *session.update("com.exercise.dao.IStudentDao.updateStudent", stu);*/
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
//		��������
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		try{
			mapper.deleteStudent(id);
			/*//����һ��
			 *session.delete("com.exercise.dao.IStudentDao.deleteStudent", 10);*/
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
	}	
}
