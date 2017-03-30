package com.sprint.dao;

import com.sprint.entity.Student;
import com.sprint.util.DBReflectionUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class StudentDao {

	//更新部分数据通过一个条件
	public boolean updatePartAgeAndSchoolById(int age, String school, int id) {
		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("age", age);
		updateMap.put("school", school);
		Map<String, Object> option = new HashMap<String, Object>();
		option.put("id", id);
		return DBReflectionUtil.updateByKey("students", updateMap, option, "=");
	}
	//更新部分数据通过1个以上条件
	public boolean updatePartAgeAndSchool(int age, String school, int id, String name) {
		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("age", age);
		updateMap.put("school", school);
		Map<String, Object> option = new HashMap<String, Object>();
		option.put("id", id);
		option.put("name", name);
		return DBReflectionUtil.updateByKeys("students", updateMap, option, "=", "and");
		
	}
	//更新所有的数据
	public boolean updateAgeAndSchool(int age, String school) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", age);
		map.put("school", school);
		return DBReflectionUtil.updateAll("students", map);
	}
	/*通过主键进行删除*/
	public boolean deleteByName(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		return DBReflectionUtil.deleteByKey("students", map, "=");
	}

	/*通过公共性数据（学校）进行删除*/
	public boolean deleteMoreBySchool(String school) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("school", school);
		return DBReflectionUtil.deleteByKey("students", map, "=");
	}

	/*通过多个模糊字进行删除*/
	public boolean deleteLikeNameAndSchool(String name, String school) {
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("name", name);
		map.put("school", school);
		return DBReflectionUtil.deleteByKeys("students", map, "like", "and");	
	}

	/*数据存储*/
	public boolean insert(Student stu) {
		Student u = findByName(stu.getName());
		if (u != null) {
			System.out.println("该对象已存在");
			return false;
		}
		return DBReflectionUtil.insert("students", stu);
	}

	/*通过主键进行查询*/
	public Student findByName(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		return DBReflectionUtil.findOnlyByKey("students", new Student(), map, "=");
	}
/*	public boolean deleteStudent(int age, String sex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", age);
		map.put("sex", sex);
		return DBReflectionUtil.deleteMoreByKeys("students", map, "=", "and");
	}

	public boolean deleteMoreLikeNameAndSchool(String name, String school) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("school", school);
		return DBReflectionUtil.deleteMoreByKeys("students", map, "like", "and");
			
	}

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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return DBReflectionUtil.findOnlyByKey("students", new Student(), map, "=");	
	}

	public List<Student> findBySex(String sex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sex", sex);
		return DBReflectionUtil.findMoreByKey("students", new Student(), map, "=");
	}

	public List<Student> findMoreByKeys(String sex, String school) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sex", sex);
		map.put("school", school);
		return DBReflectionUtil.findMoreByKeys("students", new Student(), map, "=","and");
	}

	public List<Student> findLikeNameAndSchool(String name, String school) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("school", school);
		return DBReflectionUtil.findMoreByKeys("students", new Student(), map, "like", "and");
	}
*/
}
