package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class StudentService {
	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	public StudentService() {}
	
	public List<Student> selectStudentByAll(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		//sqlSession.close();
		return studentDao.selecStudentByAll();
		
	}
	
	public int insertStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		
		int res = studentDao.insertStudent(student);
		sqlSession.commit();
		return res;
	}
	public int insertStudentWithPhone(Student student){
		int res = -1;
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertStudentWithPhone(student);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//selectStudentByNo
	public Student selectStudentByNo(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		return studentDao.selectStudentByNo(studNo);
	}
	//updateStudent
	public int updateStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		
		int res = studentDao.updateStudent(student);
		sqlSession.commit();
		return res;
	}
	//deleteStudent
	public int deleteStudent(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		
		int res = studentDao.deleteStudentByNo(studNo);
		sqlSession.commit();
		return res;
	}
}











