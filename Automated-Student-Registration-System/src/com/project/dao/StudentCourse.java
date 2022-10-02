package com.project.dao;

public class StudentCourse {

	private String username;
	private String password;
	private String cname;
	
	public StudentCourse()
	{
		
	}
	public StudentCourse(String username, String password,String cname)
	{
		this.username = username;
		this.password = password;
		this.cname = cname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "StudentCourse [username=" + username + ", password=" + password + ", cname=" + cname + "]";
	}
	
	
}
