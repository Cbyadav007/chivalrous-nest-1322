package com.project.dao;

public class BatchStudent {

	private String batch_name;
	private int roll;
	private String name;
	private String email;
	private String password;
	private int marks;
	
	public BatchStudent()
	{
		
	}
	
	public BatchStudent(String batch_name,int roll,String name,String email,String password,int marks)
	{
		this.batch_name = batch_name;
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.password = password;
		this.marks = marks;
	}

	public String getBatch_name() {
		return batch_name;
	}

	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "BatchStudent [batch_name=" + batch_name + ", roll=" + roll + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", marks=" + marks + "]";
	}
	
	
	
	
}
