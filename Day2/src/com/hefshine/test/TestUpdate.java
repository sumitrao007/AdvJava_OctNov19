package com.hefshine.test;

import com.hefshine.bean.Student;
import com.hefshine.dao.StudentDAO;

public class TestUpdate {

	public static void main(String[] args) {
		
		Student student=new Student();
		student.setId(3);
		student.setFname("Alok");
		student.setLname("Kolekar");
		
		StudentDAO studentDAO=new StudentDAO();
		int status=studentDAO.updateData(student);
		
		if (status > 0) {
			System.out.println("Data is Updatated Succefully");
		} else {
			System.out.println("Data is Not Updatated Succefully");
		}

	}

}
