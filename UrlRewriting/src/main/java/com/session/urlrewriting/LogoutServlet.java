package com.session.urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet { 
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("common.html").include(req, res);
		String userName = req.getParameter("name");
		String passWord = req.getParameter("pwd");
		
		if ((userName.equals("Niku")) && (passWord.equals("Niku"))) {
			out.print("<a href='/UrlRewriting/profile> Click Here </a>");
			out.print(" In the Logout page & Going to profile page........");
		}
	}
	

}
