package com.hefshine.test;

import com.hefshine.bean.Student;
import com.hefshine.dao.StudentDAO;

public class TestparticularData {

	public static void main(String[] args) {
		
		StudentDAO studentDAO=new StudentDAO();
		Student student=new Student();
		student=studentDAO.getParticularData(1);
		
		System.out.println("Student Id is  "+student.getId());
		System.out.println("Student Roll Number is  "+student.getRollnumber());
		System.out.println("Student First name is  "+student.getFname());
		System.out.println("Student Last name is  "+student.getLname());
		

	}

}
