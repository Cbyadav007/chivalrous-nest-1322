package com.project.dao;

import java.util.List;

import com.project.bean.Course;
import com.project.bean.Student;
import com.project.exception.StudentException;

public interface StudentDao {

	
	
	
	public String registerStudent(Student student);
	
	public String loginStudent(String username, String password) throws StudentException;
	
	
	public String registerInCourse( String username, String password, String cname) throws StudentException;
	public String updateCourse(String username, String cn) throws StudentException;
	public List<Course> availableCourse();
}
