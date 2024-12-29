package com.httpsession.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("common.html").include(req, res);
		
		String userName = req.getParameter("name");
		String passWord = req.getParameter("pwd");
		HttpSession session = req.getSession();	
		if(session != null) {

			String attribute = (String) session.getAttribute("userName");
			out.print("Heyy!!! Welcome to Profile page ... " + attribute );
			
		}
		else {
			out.print("Invalid Credentials........... Please enter valid credentials");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
			requestDispatcher.forward(req, res);
		}
		
	}

}
