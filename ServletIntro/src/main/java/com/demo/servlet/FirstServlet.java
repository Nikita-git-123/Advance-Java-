package com.demo.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {
	
	public FirstServlet() { 
		System.out.println("First servlet object is creaated.");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy method is called");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return "";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Init method is called.");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Service method is called.");
	}

}


