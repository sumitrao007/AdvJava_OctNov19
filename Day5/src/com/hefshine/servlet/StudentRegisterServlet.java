package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.bean.RegisterStudent;
import com.hefshine.dao.StudentDAO;

/**
 * Servlet implementation class StudentRegisterServlet
 */
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentname=request.getParameter("studentname");
		String gender=request.getParameter("gender");
		String degree =request.getParameter("degree");
		String technology[]=request.getParameterValues("technology");
		
		RegisterStudent registerStudent=new RegisterStudent();
		registerStudent.setName(studentname);
		registerStudent.setGender(gender);
		registerStudent.setDegree(degree);
		
		String tech="";
		
		for(int i=0;i<technology.length;i++) {
			tech=tech+technology[i]+",";
			
		}
		
		registerStudent.setTechnology(tech);
		
		
		ServletContext context=getServletContext();
		String conectionDriver=context.getInitParameter("conectionDriver");
		String connectionURL=context.getInitParameter("connectionURL");
		String dbuser=context.getInitParameter("dbuser");
		String dbpassword=context.getInitParameter("dbpassword");
		
		
		ServletConfig config=getServletConfig();
		
		String trainer1=config.getInitParameter("Trainer1");
		String trainer2=config.getInitParameter("Trainer2");
		
		System.out.println("Trainer 1 Name "+trainer1);
		System.out.println("Trainer 2 Name "+trainer2);
		
		
		StudentDAO dao=new StudentDAO(conectionDriver,connectionURL,dbuser,dbpassword);
		int status=dao.StudentRegister(registerStudent);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><head><title>My Login Page</title></head><body>");
		if(status>0) {
			pw.print("<h1>User Register Successfully </h1>");
		}else
		{
			pw.print("<h1>User Register Not Successfully </h1>");
		}
		pw.print("</body></html>");
		pw.close();
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
