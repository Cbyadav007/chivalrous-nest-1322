package com.project.usecases;

import java.util.Scanner;

import com.project.bean.Admin;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class LoginAdminUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		
		AdminDao adao = new AdminDaoImpl();
		
		try {
			Admin ad = adao.loginAdmin(username,password);
			System.out.println("Welcome "+ ad.getUsername());
			System.out.println("Select what you want to do");
			System.out.println("1. Add new Course");
			System.out.println("2. Update Fees of Course");
			System.out.println("3. Delete Course");
			System.out.println("4. Search information about Course");
			System.out.println("5. Create Batch under Course");
			System.out.println("6. Allocate Student in a Batch under a Course");
			System.out.println("7. Update total Seats of a Batch");
			System.out.println("8. View the Student of Every Batch");
			
			int achoice = sc.nextInt();
			
			if(achoice==1)
			{
				AddCourseUserCase.main(null);
			}
			else if(achoice==2)
			{
				UpdateFeesUserCase.main(null);
			}
			else if(achoice==3)
			{
				DeleteCourseUserCase.main(null);
			}
			else if(achoice==4)
			{
				CourseInformationUserCase.main(null);
			}
			else if(achoice== 5)
			{
				CreateBatchUserCase.main(null);
			}
			else if(achoice==6)
			{
				AllocateStudentInBatchUserCase.main(null);
			}
			else if(achoice==7)
			{
				UpdateSeatUserCase.main(null);
			}
			else if(achoice==8)
			{
				ViewBatchStudentUserCase.main(null);
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
