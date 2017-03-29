package com.sprint.entity;

public class Student {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String school;
	private String major;
	private String clazz;

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[")
								.append(id).append(",")
								.append(name).append(",")
								.append(age).append(",")
								.append(sex).append(",")
								.append(school).append(",")
								.append(major).append(",")
								.append(clazz).append("]");
		return sb.toString();
	}
	public Student() {
	}

	public Student(int id, String name, int age, String sex,
					String school, String major, String clazz) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.school = school;
		this.major = major;
		this.clazz = clazz;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getSchool() {
		return school;
	}

	public String getMajor() {
		return major;
	}

	public String getClazz() {
		return clazz;
	}
}
