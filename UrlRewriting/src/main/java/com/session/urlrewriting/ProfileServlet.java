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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("common.html").include(req, res);
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		if ((userName.equals("Niku")) && (passWord.equals("Niku"))) {
			out.print("Heyy!!! Welcome to Profile page ... " + userName);
			
		}
		
	}

}
