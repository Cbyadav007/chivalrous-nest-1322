package com.project.bean;

public class Course {

	private int cid;
	private String cname;
	private String duration;
	private double fees;
	private int totalSeat;
	private int remainingSeat;
	public Course()
	{
		
	}
	
	public Course(int cid, String cname, String duration,double fees, int totalSeat, int remainingSeat)
	{
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.fees = fees;
		this.totalSeat = totalSeat;
		this.remainingSeat = remainingSeat;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getRemainingSeat() {
		return remainingSeat;
	}

	public void setRemainingSeat(int remainingSeat) {
		this.remainingSeat = remainingSeat;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", fees=" + fees + ", totalSeat="
				+ totalSeat + ", remainingSeat=" + remainingSeat + "]";
	}

	
	
	
	
}
