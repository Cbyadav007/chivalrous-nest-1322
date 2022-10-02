package com.project.usecases;

import java.util.Scanner;

import com.project.bean.Student;
import com.project.dao.StudentDao;
import com.project.dao.StudentDaoImpl;
import com.project.exception.StudentException;

public class LoginStudentUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("STUDENT LOGIN");
		System.out.println("==============================");
		
		System.out.println("Enter email for login");
		String email = sc.next();
		System.out.println("Enter password for login");
		String password = sc.next();
		
		StudentDao stu = new StudentDaoImpl();
		
		try {
		String msg = stu.loginStudent(email, password);
		
		System.out.println(msg);
		System.out.println("Select what you want to do");
		System.out.println("1. Register in Course");
		System.out.println("2. Update Course");
		System.out.println("3. See Available Course");
		
		int stchoice = sc.nextInt();
		
		if(stchoice==1)
		{
			RegisterInCourseUserCase.main(null);
		}
		else if(stchoice==2)
		{
			UpdateCourseUserCase.main(null);
		}
		else if(stchoice==3)
		{
			AvailableCourseUserCase.main(null);
		}
		else
		{
			System.out.println("Please Select Correct Option");
		}
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
