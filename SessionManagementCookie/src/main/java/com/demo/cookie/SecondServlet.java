package com.demo.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();
		if(cookies[0] != null ) {
			
			PrintWriter out = res.getWriter();
			out.println("Second Servlet..........." );
			
			String name1 = cookies[0].getName();
			String value1 = cookies[0].getValue();
			
			System.out.println(name1);
			System.out.println(value1);
		}
		  else {
		    	PrintWriter out = res.getWriter();
		    	out.print("Please login again.........");
		    	RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
		    	requestDispatcher.include(req, res);
		    }
		
	
		
	}

}
