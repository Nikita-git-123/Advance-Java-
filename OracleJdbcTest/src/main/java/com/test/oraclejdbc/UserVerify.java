package com.test.oraclejdbc;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserVerify extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		String uemail = request.getParameter("Uemail");
		
		SendEmail sm = new SendEmail();
		String code = sm.generateOTP();
		
		User user = new User(uemail, code);
		
		try {
			boolean test = sm.sendEmail(user);
			
			if(test) {
				HttpSession session =request.getSession();
				session.setAttribute("authcode", user);
				response.sendRedirect("PwdSet.html");
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	

}
