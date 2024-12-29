<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"  import="com.test.jsp.JspTest"  %>
    
<% 
    String uname = request.getParameter("name");
    pageContext.setAttribute("user", uname, PageContext.REQUEST_SCOPE);
    
%>
 
 
 <%= pageContext.getAttribute("user", PageContext.REQUEST_SCOPE) %> 
 
 <%-- 10/0  --%>  
 
 <%! 
 public void init() throws ServletException {
	 JspTest.ADD();
 }
 %>
 
 <%  out.println(page.toString());%>
 
 