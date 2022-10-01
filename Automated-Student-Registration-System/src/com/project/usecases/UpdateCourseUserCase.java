package com.project.usecases;

import java.util.Scanner;

import com.project.dao.StudentDao;
import com.project.dao.StudentDaoImpl;
import com.project.exception.StudentException;

public class UpdateCourseUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Update Course");
		System.out.println("============================");
		
		System.out.println("Enter username to update the course");
		String username = sc.next();
		
		System.out.println("Enter name of Updated Course");
		String cn = sc.next();
		StudentDao stu = new StudentDaoImpl();
		
		
		try {
			String msg = stu.updateCourse(username,cn);
			System.out.println(msg);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
