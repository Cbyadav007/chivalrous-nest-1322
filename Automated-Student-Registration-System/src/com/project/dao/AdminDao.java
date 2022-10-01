package com.project.dao;

import java.sql.ResultSet;
import java.util.List;

import com.project.bean.Admin;
import com.project.bean.Course;
import com.project.bean.Student;
import com.project.exception.AllocateStudentException;
import com.project.exception.BatchException;
import com.project.exception.CourseException;
import com.project.exception.StudentException;

public interface AdminDao {

	public Admin loginAdmin(String username, String password);
	
	public String addCourse(int cid, String cname, String duration, double fees, int totalSeat, int remainingSeat);
	
	public String updateFees(String cname);
	
	public String deleteCourse(int cid) throws CourseException;
	
	public Course courseInformation(String cname);
	
	public String createBatchUnderCourse(int batchid, String batch_name, int Seat) throws CourseException;
	
	public String allocateStudentInBatch(int batchid, String batch_name) throws AllocateStudentException, BatchException, StudentException;
	
	public String updateSeat(String batch_name,int nseat) throws BatchException;
	
	public List<BatchStudent> getStudentOfAllBatch();
}
