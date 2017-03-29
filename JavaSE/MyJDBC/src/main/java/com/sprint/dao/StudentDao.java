package com.sprint.dao;

import com.sprint.entity.Student;
import com.sprint.util.DBReflectionUtil;
import java.util.ArrayList;
import java.util.List;
public class StudentDao {
	public boolean insertStudent(Student student) {
		return DBReflectionUtil.insert("students", student);
	}	

	public Student findByKey(int id) {
		List<Student> list = DBReflectionUtil.findAll("students", new Student());
		for (Student stu : list) {
			System.out.println(stu.getId());
			if (stu.getId() == id) {
				return stu;
			}
		}
		return null;
	}

	public Student findById(int id) {
		return DBReflectionUtil.findOnlyByKey("students", new Student(), "id", id);	
	}

	public List<Student> findBySex(String sex) {
		return DBReflectionUtil.findMoreByKey("students", new Student(), "sex", sex);
	}
}
