package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletHtml implements Servlet {

	@Override
	public void destroy() {
		System.out.println("Inside destroy()");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Inside init()");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		writer.print("Welcome to Servlet with HTML.........");
		String parameter1 = req.getParameter("uname");
		String parameter2 = req.getParameter("pass");
		writer.print("<h1> " + "Hey.... " + "</h1>");
	}

}

