package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Admin;
import com.project.bean.Course;
import com.project.bean.Student;
import com.project.exception.StudentException;
import com.project.utility.DBUtil;

public class StudentDaoImpl implements StudentDao{


	@Override
	public String registerStudent(Student student) {
		// TODO Auto-generated method stub
		String msg = "Not Inserted";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("insert into student(name,marks,email,password) values(?,?,?,?)");
			
			ps.setString(1, student.getName());
			ps.setInt(2,student.getMarks());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPassword());
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Student Registered Successfully";
			}
			
		}catch(SQLException e)
		{
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String loginStudent(String email, String password) throws StudentException {
		// TODO Auto-generated method stub
		String msg = "Not Login";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from student where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int r = rs.getInt("roll");
				String n = rs.getString("name");
				String user = rs.getString("email");
				String pass = rs.getString("password");
				int m = rs.getInt("marks");
			Student	student = new Student(r,n,user,pass,m);
			msg = "Login Successfull!";
			}
			else
			{
			
				throw new StudentException("Invalid Username or Password");
			}
		}
		catch(SQLException e)
		{
			
			System.out.println(e.getMessage());
		}
		
		return msg;
		
		
	}

	@Override
	public String registerInCourse(String username, String password, String cname) throws StudentException {
		// TODO Auto-generated method stub
		String msg = "Not Registered";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("insert into student_course values(?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, cname);
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Successfully! Student Registered in Course";
				
				PreparedStatement ps1 = conn.prepareStatement("update course set Remaining_Seat=Remaining_Seat-1 where cname = ?");
				ps1.setString(1, cname);
				
				int y = ps1.executeUpdate();
			}
			else
			{
				throw new StudentException("Student Not Present");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public String updateCourse(String username, String cn) throws StudentException {
		// TODO Auto-generated method stub
		String msg = "Course Not Updated";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("update student_course set cname = ? where username = ?");
			ps.setString(1,cn);
			ps.setString(2, username);
	
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Successfully! Course Updated";
			}
			else
			{
				throw new StudentException("Username or course Not Present");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<Course> availableCourse() {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from course where Remaining_Seat > 0");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int cid = rs.getInt("cid");
				String cn = rs.getString("cname");
				String d = rs.getString("duration");
				Double f = rs.getDouble("fees");
			
				int ts = rs.getInt("Total_Seat");
				int ss = rs.getInt("Remaining_Seat");
				
				list.add(new Course(cid,cn,d,f,ts,ss));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return list;
	}

}
