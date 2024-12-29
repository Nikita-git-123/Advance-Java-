package com.demo.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
	PrintWriter out = res.getWriter();
	out.println("Welcome to the first servlet");
	out.println("This the filter test.....");
	}

}
