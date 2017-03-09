package kr.or.dgit.mybatis_study;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

public class StudentDaoTest {
	private static StudentService studentService;
	   @BeforeClass
	   public static void setUpBeforeClass() throws Exception {
	      studentService = StudentService.getInstance();
	   }

	   @AfterClass
	   public static void tearDownAfterClass() throws Exception {
	      studentService = null;
	   }

	   @Test
	   public void testSelectStudentByAll() {
		   Student student = new Student(7, "설동훈","sdh23@test.co.kr", new Date());
	      int res = studentService.insertStudent(student);
	      Assert.assertEquals(1, res);
	   }
	  /* @Test
	   public void testInsertStudent(){
		   Student student = new Student(3,"박진실","lovetrue@love.love.love" ,new Date());
		   
		   int res = studentService.insertStudent(student);
		   
		   Assert.assertEquals(1, res);
	   }*/
	   
	   @Test
	   public void testSelectStudentByNo(){
		   Student student = studentService.selectStudentByNo(5);
		   Assert.assertNotNull(student);
	   }
	  /* @Test
	   public void testUpdateStudent(){
		   Student student = new Student(2,"김성환", "lovelove@love.love", new Date());
		   int res = studentService.updateStudent(student);
		   Assert.assertEquals(1, res);
	   }*/
	   @Test
	   public void testDeleteStudent(){
		   int student = studentService.deleteStudent(2);
		   Assert.assertNotNull(student);
	   }
}
