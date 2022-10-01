package com.project.usecases;

import java.util.Scanner;

import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
import com.project.exception.CourseException;

public class DeleteCourseUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Delete Course by its Id");
		System.out.println("=================================");
		
		System.out.println("Enter Course Id to Delete Course");
		int cid = sc.nextInt();
		
		AdminDao admin = new AdminDaoImpl();
		
	
		try {
			String msg = admin.deleteCourse(cid);
			System.out.println(msg);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
