package com.project.usecases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
import com.project.utility.DBUtil;

public class AddCourseUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		public Course(int cid, String cname, String duration,double fees, int seat)
	
		Scanner sc = new Scanner(System.in);
		
	System.out.println("Enter Course Id");
	int cid = sc.nextInt();
	System.out.println("Enter Course Name");
	String cname = sc.next();
	System.out.println("Enter duration of Course");
	String duration = sc.next();
	System.out.println("Enter Course Fees");
	double fees = sc.nextDouble();
	System.out.println("Enter Total Number of Seat in "+ cname +" Course");
	int totalSeat = sc.nextInt();
	int remainingSeat = totalSeat;
	
	AdminDao admin = new AdminDaoImpl();
	String msg = admin.addCourse(cid, cname, duration, fees, totalSeat,remainingSeat);
	System.out.println("===============================");
	System.out.println(msg);
	System.out.println("===============================");
	
		
	}

}
