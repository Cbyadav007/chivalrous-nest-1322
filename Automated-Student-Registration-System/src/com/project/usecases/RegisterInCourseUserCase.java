package com.project.usecases;

import java.util.Scanner;

import com.project.dao.StudentDao;
import com.project.dao.StudentDaoImpl;
import com.project.exception.StudentException;

public class RegisterInCourseUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Register Student in Course");
		System.out.println("=============================");
		
		System.out.println("Enter username (References student(email))");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		System.out.println("Enter course name (references course(cname))");
		String cname = sc.next();
		
		StudentDao stu = new StudentDaoImpl();

		try {
			String msg = stu.registerInCourse(username, password, cname);
			System.out.println(msg);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
