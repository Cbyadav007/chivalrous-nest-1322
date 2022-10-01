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
import com.project.exception.AllocateStudentException;
import com.project.exception.BatchException;
import com.project.exception.CourseException;
import com.project.exception.StudentException;
import com.project.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin loginAdmin(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from admin where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String user = rs.getString("username");
				String pass = rs.getString("password");
				admin = new Admin(user,pass);
			}
		}
		catch(SQLException e)
		{
			e.getMessage();
		}
		
		
		
		return admin;
	}
	
	@Override
	public String addCourse(int cid, String cname, String duration, double fees, int totalSeat, int remainingSeat) {
		// TODO Auto-generated method stub
		
		String msg = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?,?,?)");
			
			ps.setInt(1, cid);
			ps.setString(2, cname);
			ps.setString(3, duration);
			ps.setDouble(4, fees);
			ps.setInt(5, totalSeat);
			ps.setInt(6, remainingSeat);
			
			int x = ps.executeUpdate();
		
			if(x>0)
			{
				msg = "Course Added Successfully";
				
			}
			else
			{
				msg = "Course Not Added";
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String updateFees(String coname) {
		// TODO Auto-generated method stub
		String msg = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("update course set fees = fees+10000 where cname = ?");
			
			ps.setString(1, coname);
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Fees Updated Successfully";
			}
			else
			{
				msg = "Fees Not Updated";
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public String deleteCourse(int cid) throws CourseException {
		// TODO Auto-generated method stub
		String msg = "Course Not Deleted";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("delete from course where cid = ?");
			ps.setInt(1, cid);
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Course Deleted Successfully";
			}
			else
			{
				throw new CourseException("Course Not Found");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public Course courseInformation(String coname) {
		// TODO Auto-generated method stub
	Course course = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from course where cname = ?");
			
			ps.setString(1, coname);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next())
			{
				int cid = rs.getInt("cid");
				String couname = rs.getString("cname");
				String dur = rs.getString("duration");
				double fe = rs.getDouble("fees");
				int tseat = rs.getInt("Total_Seat");
				int rseat = rs.getInt("Remaining_Seat");
				
				 course = new Course(cid,coname,dur,fe,tseat,rseat);
			}
			else
			{
				System.out.println("Course Not Found");
			}
		
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return course;
	}

	@Override
	public String createBatchUnderCourse(int batchid, String batch_name,int Seat) throws CourseException {
		// TODO Auto-generated method stub
		String msg = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement pss = conn.prepareStatement("select * from course where cid = ?");
			
			pss.setInt(1, batchid);
			
			ResultSet rs = pss.executeQuery();
			
		if(rs.next())
		{
			
			PreparedStatement ps = conn.prepareStatement("insert into batch_course values(?,?)");
			
			ps.setInt(1, batchid);
			ps.setString(2, batch_name);
		
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Successfully Batch created inside Course";
				
				PreparedStatement psb = conn.prepareStatement("insert into batch values(?,?)");
				psb.setString(1, batch_name);
				psb.setInt(2, Seat);
				int b = psb.executeUpdate();
			}
			else
			{
				msg = "Batch not created";
			}
		}
		else
		{
			throw new CourseException("Invalid Course...");
		}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		return msg;
	}

	@Override
	public String allocateStudentInBatch(int batchid, String batch_name) throws AllocateStudentException, BatchException, StudentException {
		// TODO Auto-generated method stub
		String msg = "Not Registered";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps1 = conn.prepareStatement("select * from student where roll=?");
			ps1.setInt(1, batchid);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next())
			{
//				PreparedStatement ps2 = conn.prepareStatement("select * from batch where batch_name=?");
//				ps2.setString(2, batch_name);
//				ResultSet rs2 = ps2.executeQuery();
//				if(rs2.next())
//				{
					PreparedStatement ps3 = conn.prepareStatement("insert into batch_student values(?,?)");
					ps3.setInt(1, batchid);
					ps3.setString(2, batch_name);
					
					int x = ps3.executeUpdate();
					if(x>0)
					{
						msg = "Successfull! Student registered in Batch";
						PreparedStatement ps4 = conn.prepareStatement("update batch set Seat=Seat-1 where batch_name=?");
						ps4.setString(1, batch_name);
						int z = ps4.executeUpdate();
					}
					else
					{
						throw new AllocateStudentException("Student not allocated in Batch");
					}
				}
//				else
//				{
//					throw new BatchException("Batch Not Found");
//				}
//			}
			else
			{
				throw new StudentException("Student not found");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return msg;
	}

	@Override
	public String updateSeat(String batch_name,int nseat) throws BatchException {
		// TODO Auto-generated method stub
		String msg = "Batch Seat Not Updated";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("update batch set Seat=? where batch_name=?");
			ps.setInt(1, nseat);
			ps.setString(2, batch_name);
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg = "Successfully! Batch Seat Updated";
			}
			else
			{
				throw new BatchException("Batch Not Found");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<BatchStudent> getStudentOfAllBatch() {
		// TODO Auto-generated method stub
		List<BatchStudent> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select b.batch_name,s.roll,s.name,s.email,s.password,s.marks from batch_student b inner join student s on b.batchid = s.roll");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String bn = rs.getString("batch_name");
				int r = rs.getInt("roll");
				String n = rs.getString("name");
				String e = rs.getString("email");
				String p = rs.getString("password");
				int m = rs.getInt("marks");
				
				list.add(new BatchStudent(bn,r,n,e,p,m));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return list;
	}

	

}
