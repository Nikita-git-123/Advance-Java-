package com.session.urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
	
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
		
		@Override
		public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
			
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();	
			req.getRequestDispatcher("common.html").include(req, res);
			
			String userName = req.getParameter("name");
			String passWord = req.getParameter("pwd");
			
			if ((userName.equals("Niku")) && (passWord.equals("Niku"))) {
				out.print("<a href='/UrlRewriting/profile?userName=" + userName + "&" + "passWord=" + passWord + " '> Click Here </a> " );
			}
			else {
				out.print(" Invalid Credentials........... Please enter valid credentials ");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
				requestDispatcher.forward(req, res);
			}
			
			out.close();
		}

}

