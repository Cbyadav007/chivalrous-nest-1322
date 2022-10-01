package com.project.usecases;

import java.util.Scanner;

import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
import com.project.exception.BatchException;

public class UpdateSeatUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Update Batch Seat");
		System.out.println("==============================");
		
		System.out.println("Enter Batch Name to Update Seat");
		String bname = sc.next();
		System.out.println("Enter number of Seat you want");
		int nseat = sc.nextInt();
		
		AdminDao admin = new AdminDaoImpl();
		
		try {
			String msg = admin.updateSeat(bname,nseat);
			System.out.println(msg);
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
