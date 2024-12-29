package com.test.oraclejdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Uname = request.getParameter("Uname");
		String Uemail = request.getParameter("Uemail");
		String Uphone = request.getParameter("Uphone");
		String Username = request.getParameter("Username");
		String Upwd1 = request.getParameter("Upwd1");
		String Upwd2 = request.getParameter("Upwd2");
		
		
		if(Upwd1.equals(Upwd2)) {
			
			/*
			 * PrintWriter out = response.getWriter(); out.print("Successful............");
			 */
			try {
				
				Connection conn1 = ConnectionJDBC.GetConnection();
				PreparedStatement statement = conn1.prepareStatement("Insert into Registration values(?,?,?,?,?");
				statement.setString(1, Uname);
				statement.setString(2, Uemail);
				statement.setString(3, Uphone);
				statement.setString(4, Username);
				statement.setString(5, Upwd1);
				
				//int executeUpdate = statement.executeUpdate();
				
				//if(executeUpdate != 0 ) {
					
					PrintWriter out = response.getWriter();
					out.print("Registration successful.........");
					
					/*
					 * RequestDispatcher requestDispatcher2 =
					 * request.getRequestDispatcher("Registration.html");
					 * requestDispatcher2.forward(request, response);
					 */
					
					Connection conn2 = ConnectionJDBC.GetConnection();
					PreparedStatement prapareStatement = conn2.prepareStatement("Insert into Login values(?,?");
					statement.setString(1, Username);
					statement.setString(2, Upwd1);
					
				    statement.executeUpdate();
				    
					/*
					 * conn2.close(); prapareStatement.close(); conn1.close(); statement.close();
					 */
				//}
				//else {
					
					
					//PrintWriter out = response.getWriter();
					//out.print("Registration failed.....................");
					
					/*
					 * RequestDispatcher requestDispatcher3 =
					 * request.getRequestDispatcher("SomethingWrong.html");
					 * requestDispatcher3.forward(request, response);
					 */
				//}
				
				//RequestDispatcher requestDispatcher = request.getRequestDispatcher("Registration.html");
				//requestDispatcher.forward(request, response);
			} 
			catch(Exception ex) {
				ex.getStackTrace();
			}
		}
		else {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("PasswordMismatch.html");
			requestDispatcher.forward(request, response);
		}
	}
}
