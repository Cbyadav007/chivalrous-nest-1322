package com.project.usecases;

import java.util.Scanner;

import com.project.bean.Student;
import com.project.dao.StudentDao;
import com.project.dao.StudentDaoImpl;

public class RegisterStudentUseCase {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student name");
		String name = sc.next();
		System.out.println("Enter Student email");
		String email = sc.next();
		System.out.println("Enter Student password");
		String password = sc.next();
		System.out.println("Enter Student marks");
		int marks = sc.nextInt();
		
		StudentDao sdao = new StudentDaoImpl();
		
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setMarks(marks);
		
		String msg = sdao.registerStudent(student);
		System.out.println(msg);
		
		
		
	}



}
