package com.sprint.dao;

import com.sprint.entity.Student;
import com.sprint.dao.StudentDao;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
public class StudentDaoTest {

	StudentDao sd = new StudentDao();
/*		
	
	@Test //success 
	public void testInsert() {
		Student stu = new Student(2, "姓名2", 12, "男", "CodeUniversity", "软件工程", "1403");
		sd.insert(stu);
		for (int i = 0; i < 5; i++) {
			Student stu1 = new Student(i, "轮子" + i, 12, "男", "中国鲁东大学", "软件工程", "1403");
			sd.insert(stu1);
		}
	
	}

	@Test //success
	public void testDeleteLikeNameAndSchool() {
		sd.deleteLikeNameAndSchool("name%", "Code%");	
	} 

	@Test //success
	public void testDeleteMoreBySchool() {
		sd.deleteMoreBySchool("鲁东大学");
	}

	@Test //success 
	public void testDeleteByName() {
		sd.deleteByName("姓名1");	
	}

	@Test //success 
	public void updateAgeAndSchool() {
		sd.updateAgeAndSchool(1000, "世纪鲁东大学");
	}
	@Test
	public void updatePartAgeAndSchool() {
		System.out.println(sd.updatePartAgeAndSchool(18, "鲁东大学", 65, "姓名3"));
	}
*/
	@Test
	public void updatePartAgeAndSchoolById() {
		System.out.println(sd.updatePartAgeAndSchoolById(120, "烟台大学", 65));
	}

/*	@Test
	public void testDeteleLikeNameAndSchool() {
		sd.deleteMoreLikeNameAndSchool("test%", "Code%");	
	}
	
*/

	/*@Test
	public void testInsertStudent() {
		Student stu = new Student(2, "test1", 12, "男", "CodeUniversity", "ruanjian", "1403");
		Student stu1 = new Student(2, "test2", 12, "男", "CodeUniversity", "ruanjian", "1403");
		Assert.assertTrue(sd.insertStudent(stu));
		Assert.assertTrue(sd.insertStudent(stu1));
	}*/
	
	/*@Test
	public void testDelete() {
		sd.deleteStudent(12, "男");
	}*/
	
/*	@Test public void testNameAndSchool() {
		List<Student> list = sd.findLikeNameAndSchool("%stu%", "Code%");
		for (Student stu : list) {
	//		System.out.println(stu);
		}

	}
	@Test public void testList() {
		List<Student> list = sd.findMoreByKeys("女", "CodeUniversity");
		for (Student stu : list) {
	//		System.out.println(stu);
		}
	}
	@Test
	public void test() {
		int[] array = {1, 2, 3, 4, 5, 6};
		for (int a : array) {
			if (a == 4)
				continue;
	//		System.out.println(a);
		}
	}

	@Test 
	public void testFindStu() {

		Student stu = sd.findById(8);
		if (stu != null) {
	//		System.out.println(stu);
		} else {
	//		System.out.println("空");
		}
		List<Student> list = sd.findBySex("女");
		for (Student s : list) {
	//		System.out.println(s);
		}
	}*/
}
