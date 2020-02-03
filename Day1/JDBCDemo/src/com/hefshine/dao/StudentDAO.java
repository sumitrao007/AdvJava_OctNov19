package com.hefshine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {
	Connection con;
	PreparedStatement pst;
	private String DB_DRIVER="com.mysql.jdbc.Driver";
	private String DB_URL="jdbc:mysql://localhost:3306/octdec";
	private String DB_USER="root";
	private String DB_PASSWORD="";
	
	//Step 1&2
	public void OpenDB() {
		try {
			Class.forName(DB_DRIVER);
			con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}
	//Step 3&4
	public int insertData(int rollnumber,String fname,String lname) {
		int status=0;
		String query="INSERT INTO student (rollnumber,fname,lname) VALUES (?, ?,?);";
		
		try {
		OpenDB();		
		
		pst=con.prepareStatement(query);
		pst.setInt(1, rollnumber);
		pst.setString(2,fname );
		pst.setString(3, lname);
		status=pst.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return status;
		
	}
	
	//Step 5
	public void CloseDB() {
		
		try {
			if(con!=null) {
				con.close();
			}			
			if(pst!=null) {
				pst.close();
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
