package com.hefshine.test;

import com.hefshine.dao.StudentDAO;

public class TestApp {

	public static void main(String[] args) {
		StudentDAO studentdao=new StudentDAO();
		int status=studentdao.insertData(104 ,"Nilesh", "Dhokrat");
		
		if(status>0) {
			System.out.println("Data is Insertated Succefully");
		}else
		{
			System.out.println("Data is Not Insertated Succefully");
		}
	}
	

}
