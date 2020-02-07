package com.hefshine.bean;

public class RegisterStudent {
	int id;
	String name;
	String degree;
	String gender;
	String technology;
	
	public RegisterStudent() {
		
	}
	
	
	public RegisterStudent(int id, String name, String degree, String gender, String technology) {
		super();
		this.id = id;
		this.name = name;
		this.degree = degree;
		this.gender = gender;
		this.technology = technology;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	@Override
	public String toString() {
		return "RegisterStudent [id=" + id + ", name=" + name + ", degree=" + degree + ", gender=" + gender
				+ ", technology=" + technology + "]";
	}
	

}
