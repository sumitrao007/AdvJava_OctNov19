package com.hefshine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.hefshine.bean.Student;

public class StudentDAO {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	String conectionDriver;
	String connectionURL;
	String dbuser;
	String dbpassword;
	
	public StudentDAO(String conectionDriver,String connectionURL,String dbuser,String dbpassword) {
		this.conectionDriver=conectionDriver;
		this.connectionURL=connectionURL;
		this.dbuser=dbuser;
		this.dbpassword=dbpassword;
	}
	
	public void OpenDB() {
		try {
		Class.forName(conectionDriver);
		
		con=DriverManager.getConnection(connectionURL,dbuser,dbpassword);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean CheckUser(Student s) {
		String query="select username,password from studentlogin where username=? and password=?";
		boolean userstatus=false;
		
		try {
			OpenDB();
			pst=con.prepareStatement(query);
			pst.setString(1, s.getUsername());
			pst.setString(2, s.getPassword());
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				userstatus=true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return userstatus;
		
	}
	
	
	
	public void closeDB() {
		try {
		if(con!=null) {
			con.close();
		}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	

}
