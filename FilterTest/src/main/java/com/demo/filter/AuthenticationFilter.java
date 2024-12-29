package com.demo.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter{
	
    FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config=filterConfig;
	}
	
	public AuthenticationFilter() {
		System.out.println("AuthenticationFilter Object is created");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String initParameter = config.getInitParameter("Deployment");
	
		if(!initParameter.equalsIgnoreCase("y")) {
			String uName = req.getParameter("name");
			String uPass = req.getParameter("pwd");
			
			if(uName.equals("Niku") && uPass.equals("Niku")) {
				
				  System.out.println("Inside Authentication Filter start........ ");
				  System.out.println("Credentils validation is successful!!!");
				  chain.doFilter(req, res);
				  System.out.println("Inside Authentication Filter end........ ");
			}
			else {
				out.println("Invalid Data.....Try again.");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
				requestDispatcher.include(req, res);
			}
		}
		else {
			out.print("site is under construction");
		}
		
		
	}

}
