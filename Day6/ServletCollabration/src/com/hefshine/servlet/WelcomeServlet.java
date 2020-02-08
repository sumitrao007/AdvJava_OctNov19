package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		System.out.println("U are in Welcome Servlet");
	
	String username=request.getParameter("username");
	
	PrintWriter pw=response.getWriter();
	pw.print("<html><head><title>Welcome Servlet </title></head><body>");
	pw.print("<h1>Welcome, "+username+"</h1>");
	pw.print("</body></html>");
	pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		
//			System.out.println("U are in Welcome Servlet");
//		
//		String username=request.getParameter("username");
//		
//		PrintWriter pw=response.getWriter();
//		pw.print("<html><head><title>Welcome Servlet </title></head><body>");
//		pw.print("<h1>Welcome, "+username+"</h1>");
//		pw.print("</body></html>");
//		pw.close();
	}
	
	
	
	
	
	
	
	
	
	
	

}
