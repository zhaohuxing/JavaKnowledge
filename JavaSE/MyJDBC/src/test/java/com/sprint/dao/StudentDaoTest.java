package com.sprint.dao;

import com.sprint.entity.Student;
import com.sprint.dao.StudentDao;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
public class StudentDaoTest {

	StudentDao sd = new StudentDao();
/*	@Test
	public void testInsertStudent() {
		Student stu = new Student(2, "xingss", 12, "男", "ludong", "ruanjian", "1403");
		Assert.assertTrue(sd.insertStudent(stu));
	}
*/
	@Test
	public void test() {
		int[] array = {1, 2, 3, 4, 5, 6};
		for (int a : array) {
			if (a == 4)
				continue;
			System.out.println(a);
		}
	}

	@Test 
	public void testFindStu() {

		Student stu = sd.findById(8);
		if (stu != null) {
			System.out.println(stu);
		} else {
			System.out.println("空");
		}
		List<Student> list = sd.findBySex("女");
		for (Student s : list) {
			System.out.println(s);
		}
	}
}
