package com.project.bean;

public class Batch {

	
	private int cid;
	private int roll;
	private String batch;
	
	public Batch()
	{
		
	}
	
	public Batch(int cid, int roll, String batch)
	{
		this.cid = cid;
		this.roll = roll;
		this.batch = batch;
	}
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Batch [cid=" + cid + ", roll=" + roll + ", batch=" + batch + "]";
	}
	
	
	
	
}
