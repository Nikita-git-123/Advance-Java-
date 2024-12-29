package com.test.gmail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	
    @Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		 PrintWriter out = res.getWriter();
		 
		req.getRequestDispatcher("common.html").include(req, res);
		
		Cookie[] ck = req.getCookies();
		
		if(ck != null) {
			String uname = ck[0].getValue();
			if(uname != null) {
				out.print("Welcome to profile........ ");
			}
		}
		else {out.print("Please Login again......");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
			requestDispatcher.forward(req, res);
		}
		out.close();
	}

}
