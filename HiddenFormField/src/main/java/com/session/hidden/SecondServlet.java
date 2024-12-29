package com.session.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String userName = req.getParameter("name");
		String phoneNo = req.getParameter("phone");
		out.println("Welcome to Second Servlet " );
		out.println("User Name : " + userName);
		out.println("Phone Number : " + phoneNo);
		
	}
}
