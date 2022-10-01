package com.project.usecases;

import java.util.Scanner;

import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class UpdateFeesUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course name to Update Fees");
		String cname = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		String msg = admin.updateFees(cname);
		System.out.println(msg);
		
	}

}
