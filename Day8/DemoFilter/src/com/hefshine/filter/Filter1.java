package com.hefshine.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter1
 */
public class Filter1 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
			System.out.println("We are in doFilter Method of Filter1............");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		PrintWriter pw=resp.getWriter();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(username.trim().equalsIgnoreCase("") && password.trim().equalsIgnoreCase("")) {
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			pw.print("<h2 style='color:red'>Username & Password is not blank </h2>");
			rd.include(req, resp);
			pw.close();
			
		}else {
			System.out.println("U are in Else part of Filter1.....");
			chain.doFilter(request, response);
			
		}
			
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("Init method Call of Filter1 !!!!!!!!!!!!!!!!!");
		
	}

}
