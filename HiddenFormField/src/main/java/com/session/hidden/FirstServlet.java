package com.session.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String userName = req.getParameter("name");
		String passWord = req.getParameter("pwd");
		
		if(userName.equals("Niku") & passWord.equals("Niku")) {
			out.print("Welcome to First Servlet " );
			out.print("<form action='/HiddenFormField/second'>");
			out.print("<input type='hidden' name='name' value=" + userName + " >");
			out.print("Enter Phone : <input type='text' name='phone'>");
			out.print("<input type='submit' value='Next' >");
			out.print("</form>");
		}
		else {
			out.print(" Invalid user ...... Try again ");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
			requestDispatcher.include(req, res);
		}
	}

}
