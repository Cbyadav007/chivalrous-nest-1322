package com.project.usecases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.bean.Course;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class CourseInformationUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name to get their Information");
		String cname = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		Course course = admin.courseInformation(cname);
		
		System.out.println(course);
	}

}
