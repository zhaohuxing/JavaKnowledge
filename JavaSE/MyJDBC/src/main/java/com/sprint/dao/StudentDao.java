package com.sprint.dao;

import com.sprint.entity.Student;
import com.sprint.util.DBReflectionUtil;
public class StudentDao {
	public boolean insertStudent(Student student) {
		return DBReflectionUtil.insert("students", student);
	}	
}
