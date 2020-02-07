package com.hefshine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hefshine.bean.RegisterStudent;
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
	
	public int registerUser(Student student) {
		int status=0;
		
		String query="insert into studentlogin (username,password) values(?,?)";
		
		try {
			OpenDB();
			pst=con.prepareStatement(query);
			pst.setString(1, student.getUsername());
			pst.setString(2, student.getPassword());
			
			status=pst.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return status;
	}
	
	
	public int StudentRegister(RegisterStudent registerStudent) {
		int status=0;
		
		String query="insert into register (name,gender,degree,technology) values(?,?,?,?);";
		try {
			OpenDB();
			
			pst=con.prepareStatement(query);
			pst.setString(1, registerStudent.getName());
			pst.setString(2, registerStudent.getGender());
			pst.setString(3, registerStudent.getDegree());
			pst.setString(4, registerStudent.getTechnology());
		
			status=pst.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return status;
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
