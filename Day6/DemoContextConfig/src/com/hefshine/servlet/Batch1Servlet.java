package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Batch1Servlet
 */
public class Batch1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Batch1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext context=getServletContext();
		String InstituteName=context.getInitParameter("InstituteName");
		
		ServletConfig config=getServletConfig();
		String Trainer1=config.getInitParameter("Trainer1");
		String Trainer2=config.getInitParameter("Trainer2");
		
		System.out.println("InstituteName "+InstituteName);
		System.out.println("Trainer1 "+Trainer1);
		System.out.println("Trainer2 "+Trainer2);
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.print("<html><head><title>My Page </title></head><body>");
		
		pw.print("<h1>"+InstituteName+"</h1>");
		pw.print("<h4> Trainers "+Trainer1+"</h4>");
		pw.print("<h4> Trainers "+Trainer2+"</h4>");
		
		pw.print("</body></html>");
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
