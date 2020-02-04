package com.hefshine.test;

import com.hefshine.bean.Student;
import com.hefshine.dao.StudentDAO;

public class TestApp {

	public static void main(String[] args) {
		StudentDAO studentdao = new StudentDAO();
		
		Student student=new Student(106,"Shubham","Akurdekar");
//		student.setRollnumber(105);
//		student.setLname("Jagtap");
//		student.setFname("Snehal");
		
		int status = studentdao.insertData(student);
		
		if (status > 0) {
			System.out.println("Data is Insertated Succefully");
		} else {
			System.out.println("Data is Not Insertated Succefully");
		}

	}

}
