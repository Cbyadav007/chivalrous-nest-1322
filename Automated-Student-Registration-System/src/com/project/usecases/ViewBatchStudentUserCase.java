package com.project.usecases;

import java.util.List;
import java.util.Scanner;
import com.project.dao.*;
import com.project.bean.Student;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class ViewBatchStudentUserCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("View Student of Every Batch");
	System.out.println("===================================");
		
		AdminDao admin = new AdminDaoImpl();
		
		List<BatchStudent> list = admin.getStudentOfAllBatch();
		
		for(BatchStudent b : list)
		{
			System.out.println(b);
		}
		
		
	}

}
