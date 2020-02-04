package com.hefshine.test;

import java.util.ArrayList;

import com.hefshine.bean.Student;
import com.hefshine.dao.StudentDAO;

public class TestGetAllData {

	public static void main(String[] args) {
		
		StudentDAO studentDAO=new StudentDAO();
		ArrayList<Student> arrayList=new ArrayList<Student>();
		
		arrayList=studentDAO.getAllData();
		
		System.out.println("Array List is "+arrayList);
		
		System.out.println("Id\t Roll Number\t First name\t\t Last name");
				
		for (Student student : arrayList) {
			System.out.print(student.getId()+"\t");
			System.out.print(student.getRollnumber()+"\t");
			System.out.print(student.getFname()+"\t\t");
			System.out.println(student.getLname()+"\t");
			System.out.println("--------------------------------------------");
		}
		

	}

}
