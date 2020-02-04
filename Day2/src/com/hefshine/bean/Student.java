package com.hefshine.bean;

public class Student {
	int id;
	int rollnumber;
	String fname;
	String lname;
	
	public Student() {
		
	}
	
	public Student( int rollnumber, String fname, String lname) {
		super();
		
		this.rollnumber = rollnumber;
		this.fname = fname;
		this.lname = lname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollnumber=" + rollnumber + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
	
	
	

}
