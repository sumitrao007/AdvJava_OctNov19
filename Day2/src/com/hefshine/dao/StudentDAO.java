package com.hefshine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hefshine.bean.Student;

public class StudentDAO {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
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
	/*
	 * public int insertData(int rollnumber,String fname,String lname) { int
	 * status=0; String
	 * query="INSERT INTO student (rollnumber,fname,lname) VALUES (?, ?,?);";
	 * 
	 * try { OpenDB();
	 * 
	 * pst=con.prepareStatement(query); pst.setInt(1, rollnumber);
	 * pst.setString(2,fname ); pst.setString(3, lname); status=pst.executeUpdate();
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }finally { CloseDB(); }
	 * 
	 * return status;
	 * 
	 * }
	 */
	
	
	
	public int insertData(Student student) {
		int status=0;
		String query="INSERT INTO student (rollnumber,fname,lname) VALUES (?,?,?);";
		
		try {
		OpenDB();		
		
		pst=con.prepareStatement(query);
		pst.setInt(1, student.getRollnumber());
		pst.setString(2, student.getFname());
		pst.setString(3, student.getLname());
		status=pst.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return status;
		
	}
	
	public int updateData(Student student) {
		String query="update student set fname=? , lname=? where id=?";
		int status=0;
		try {
		OpenDB();
		
		pst=con.prepareStatement(query);
		pst.setString(1, student.getFname());
		pst.setString(2, student.getLname());
		pst.setInt(3, student.getId());
		
		status=pst.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return status;
		
	}
	
	public int deleteData(int id) {
		int status=0;
		String query="delete from student where id=?";
		try {
			OpenDB();
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
			status=pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return status;		
		
	}
	
	public ArrayList<Student> getAllData() {
		String query="select * from student";
		ArrayList<Student> arrayList=new ArrayList<Student>();
		try {
			OpenDB();
			pst=con.prepareStatement(query);			
			rs=pst.executeQuery();			
			while(rs.next()) {
				Student student=new Student();
				student.setId(rs.getInt("id"));
				student.setRollnumber(rs.getInt("rollnumber"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				arrayList.add(student);
				
			}			
			
		}catch(Exception e) {
			
		}finally {
			CloseDB();
		}
		return arrayList;
		
	}
	
	public Student getParticularData(int id) {
		Student student=new Student();
		String query="select * from student where id=?";
		
		try {
			OpenDB();
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				student.setId(rs.getInt("id"));
				student.setRollnumber(rs.getInt("rollnumber"));
				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
				
		
		return student;
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
			if(rs!=null) {
				rs.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
