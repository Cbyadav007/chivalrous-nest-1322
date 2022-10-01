package com.project.usecases;

import java.util.List;
import java.util.Scanner;

import com.project.bean.Course;
import com.project.dao.StudentDao;
import com.project.dao.StudentDaoImpl;

public class AvailableCourseUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Available Courses are : ");
		System.out.println("================================");
		
		StudentDao stu = new StudentDaoImpl();
		List<Course> list = stu.availableCourse();
		
		for(Course c : list)
		{
			System.out.println(c);
		}
		
		
	}

}
