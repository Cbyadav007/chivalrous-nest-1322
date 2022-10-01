package com.project.bean;

public class StudentCourse {

private String email;
private String password;
private int cid;

public StudentCourse()
{
	
}

public StudentCourse( String email, String password, int cid)
{
	super();

	this.email = email;
	this.password = password;
	this.cid = cid;
	
	
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

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

@Override
public String toString() {
	return "StudentDTO [email=" + email + ", password=" + password + ", cid=" + cid + "]";
}






}



