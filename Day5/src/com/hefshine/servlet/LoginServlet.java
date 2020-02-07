package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.bean.Student;
import com.hefshine.dao.StudentDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Student student=new Student();
		student.setUsername(username);
		student.setPassword(password);
		
		StudentDAO dao=new StudentDAO();
		boolean userstatus=dao.CheckUser(student);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><head><title>My Login Page</title></head><body>");
		
		if(userstatus) {
			
			pw.print("<h1>User Login Successfully </h1>");
			
		}else
		{
			pw.print("<h1>Invalid User  </h1>");
		}
		
		pw.print("</body></html>");
		pw.close();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
