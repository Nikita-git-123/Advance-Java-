package com.demo.servlethttp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletHttp implements Servlet {

	ServletConfig config;
	
	@Override
	public void destroy() {
		System.out.println("Destroy()");	
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
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletConfig servletConfig = getServletConfig();
		String url = servletConfig.getInitParameter("url");
		PrintWriter out = res.getWriter();
		out.print("<a href="+url+">click here......</a>");
	}

}
