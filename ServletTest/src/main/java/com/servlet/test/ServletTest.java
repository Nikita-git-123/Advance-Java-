package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletTest extends GenericServlet /* implements Servlet */ {
	/* ServletConfig config;

	@Override
	public void destroy() {
		System.out.println("destroy() method...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		 this.config = config;
		
	    String dbusername = config.getInitParameter("dbusername");
		String dbpassword = config.getInitParameter("dbpassword");

		try {
			JDBCConnection.getConnection(dbusername,dbpassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		ServletConfig servletConfig = getServletConfig();
		String url = servletConfig.getInitParameter("url");
		PrintWriter out = res.getWriter();

		out.print("<a href="+url+">click here...</a>");
		/* PrintWriter out = res.getWriter();
		writer.print("First Servlet test successful....");
		out.print("<h1> Welcome to servlet  </h1> ");
		out.print("<a href='http://www.facebook.com'> Welcome to servlet </a> ");
		*/
	}

}
