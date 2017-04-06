package com.sprint.dao;

import com.sprint.entity.Student;
import com.sprint.dao.StudentDao;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
public class StudentDaoTest {

	StudentDao sd = new StudentDao();

	//存储
	@Test
	public void testInsert() {
		Student stu = new Student(1, "姓名", 18, "性别", "学校","专业", "班级");
		sd.insert(stu);
	}

	//获取全部学生
	@Test
	public void testFindAll() {
		List<Student> list = sd.findAll();
		for (Student stu : list) 
			System.out.println(stu);
	}

	//多条件获取多条记录
	@Test
	public void testFindMoreByKeys() {
		List<Student> list = sd.findMoreBySexAndSchool("男", "世纪鲁东大学");
		for (Student stu : list) 
			System.out.println(stu);
				
	}

	//多条件获取单条记录
	@Test
	public void testFindOnlyByKeys() {
		Student stu = sd.findOnlyByNameAndSchool("姓名2", "烟台大学");
		System.out.println(stu);
	} 

	//单条件获取多条记录
	@Test
	public void testFindMoreByKey() {
		
		List<Student> list = sd.findMoreBySchool("世纪鲁东大学");
		for (Student stu : list) 
			System.out.println(stu);
	}

	//单条件获取单条记录
	@Test
	public void testFindOnlyByKey() {
		Student stu = sd.findOnlyById(73);
		System.out.println(stu);
	}

	//单条件删除单条
	@Test
	public void testDeleteByKey() {
		sd.deleteByName("轮子2");
	}

	//多条件删除多条
	@Test
	public void testDeleteByKeys() {
		sd.deleteLikeNameAndSchool("姓%", "%学%");
	}
}
