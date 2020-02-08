package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Student student=new Student();
		student.setUsername(username);
		student.setPassword(password);
		
		ServletContext context=getServletContext();
		String conectionDriver=context.getInitParameter("conectionDriver");
		String connectionURL=context.getInitParameter("connectionURL");
		String dbuser=context.getInitParameter("dbuser");
		String dbpassword=context.getInitParameter("dbpassword");
		
		StudentDAO dao=new StudentDAO(conectionDriver,connectionURL,dbuser,dbpassword);
		boolean status=dao.CheckUser(student);
		
		
		
		if(status) {
//			RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
//			rd.forward(request, response);
			
			response.sendRedirect("WelcomeServlet");
			
			
			
		}else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			PrintWriter pw=response.getWriter();
			pw.print("<h2 style=\"color: red\">Invalid User</h2>");
			rd.include(request, response);
			pw.close();
			
		}
		
		
		
		
	}

}
