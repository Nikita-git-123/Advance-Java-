package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletOne extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
	
		String name = req.getParameter("username"); 
	    String pwd = req.getParameter("pwd"); 
	    
	    Employee employee = new Employee();
	    Date date = new Date();
	    String currentDate = date.toInstant().toString();
	    employee.setDate(currentDate);
	    employee.setEmail(name + "@gmail.com");
	    req.setAttribute("employee", employee);
	    req.setAttribute("currentDate", currentDate);
	    
	    if((name.equals("niku")) && (pwd.equals("niku"))) {
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Second");
			requestDispatcher.forward(req, res);
	    }
	    else {
	    	PrintWriter out = res.getWriter();
	    	out.print("Invalid Credentials.......");
	    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
	    	requestDispatcher.include(req, res);
	    	//res.sendRedirect("http://www.facebook.com");
	    }
	

		/*
		 * ServletContext servletContext = getServletContext(); PrintWriter out =
		 * res.getWriter(); String url = servletContext.getInitParameter("url");
		 * out.print("Config Parameter : " + url);
		 */
	}
}
