package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTwo extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		PrintWriter out = res.getWriter();
		out.println("Second Servlet..........." );
		out.println("User name : " + name);
		out.println("Password : " + pwd);
		
		String attribute = (String) req.getAttribute("currentDate");
		out.println(attribute);
		
		Employee employee = (Employee) req.getAttribute("employee");
		out.println("Second Servlet....." +employee.getDate());
		out.println("Second Servlet....." +employee.getEmail());
		
	}

}
