package com.project.utility;

import java.sql.Connection;
import java.util.Scanner;

import com.project.dao.StudentDao;
import com.project.usecases.LoginAdminUseCase;
import com.project.usecases.LoginStudentUserCase;
import com.project.usecases.RegisterStudentUseCase;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Connection conn = DBUtil.provideConnection();
//		System.out.println("Database Connected Successfully!");
		System.out.println("===============================");
		System.out.println("Select Admin / Student");
		System.out.println("-------------------------------");
		System.out.println("1. Admin");
		System.out.println("2. Student");
		System.out.println("===============================");
		
		int choice = sc.nextInt();
		if(choice==1)
		{
			
			LoginAdminUseCase.main(null);
			
			// in loginAdmin() method provide all method of adminDao()
		}
		else if(choice == 2)
		{
			System.out.println("===============================");
			System.out.println("1. New Student Registration");
			System.out.println("2. Student login");
			System.out.println("===============================");
			int schoice = sc.nextInt();
			if(schoice == 1)
			{
				RegisterStudentUseCase.main(null);
			}
			else if(schoice == 2)
			{
				LoginStudentUserCase.main(null);
			}
			else
			{
				System.out.println("Please enter correct Student choice");
			}

		}
		else
		{
			System.out.println("Please enter correct choice");
		}
		
	}

}
