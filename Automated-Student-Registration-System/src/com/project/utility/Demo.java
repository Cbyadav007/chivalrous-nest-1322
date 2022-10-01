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
		System.out.println(conn);
		
		System.out.println("Tell me who are you");
		System.out.println("1. Admin");
		System.out.println("2. Student");
		
		int choice = sc.nextInt();
		if(choice==1)
		{
			
			LoginAdminUseCase.main(null);
			
			// in loginAdmin() method provide all method of adminDao()
		}
		else if(choice == 2)
		{
			System.out.println("Type 1 for new Student Registration");
			System.out.println("Type 2 for login");
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
