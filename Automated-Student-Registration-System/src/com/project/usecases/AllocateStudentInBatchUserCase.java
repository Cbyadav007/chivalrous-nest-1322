package com.project.usecases;

import java.util.Scanner;

import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
import com.project.exception.AllocateStudentException;

public class AllocateStudentInBatchUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Allocate Student in Batch");
		System.out.println("Enter batchid (references to Student(roll))");
		int batchid = sc.nextInt();
		System.out.println("Enter Batch name (references to Batch(batch_name))");
		String batch_name = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		try {
			String msg = admin.allocateStudentInBatch(batchid, batch_name);
			System.out.println(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
