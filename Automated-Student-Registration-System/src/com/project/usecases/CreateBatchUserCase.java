package com.project.usecases;

import java.util.Scanner;

import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
import com.project.exception.CourseException;

public class CreateBatchUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Create Batch Under Course");
		System.out.println("============================");
		
		System.out.println("Enter Batch Id (references to cid)");
		int batchid = sc.nextInt();
		System.out.println("Enter Batch Name");
		String batch_name = sc.next();
		System.out.println("Enter Number of Seat in Batch");
		int seat = sc.nextInt();
		
		AdminDao admin  = new AdminDaoImpl();
		
	
		try {
			String msg = admin.createBatchUnderCourse(batchid, batch_name, seat);
			System.out.println(msg);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
