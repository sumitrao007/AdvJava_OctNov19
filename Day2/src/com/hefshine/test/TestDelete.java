package com.hefshine.test;

import com.hefshine.dao.StudentDAO;

public class TestDelete {

	public static void main(String[] args) {
	
		StudentDAO studentDAO=new StudentDAO();
		int status=studentDAO.deleteData(5);
		
		if (status > 0) {
			System.out.println("Data is Deletated Succefully");
		} else {
			System.out.println("Data is Not Deletated Succefully");
		}

	}

}
