package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentMapper {
	int insertStudent(Student student);
	int insertStudentWithPhone(Student student);	//typehandler 예제
	List<Student> selecStudentByAll();
	
	//과제 테스트까지 완료 branch이용해서
	Student selectStudentByNo(int studNo);
	int updateStudent(Student student);
	int deleteStudentByNo(int studNo);
}
