package com.test.gmail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("common.html").include(req, res);
		
		out.println("Logged out successfully..........");

		Cookie ck = new Cookie("userName", "");
		ck.setMaxAge(0);
		res.addCookie(ck);
		
	}
}
