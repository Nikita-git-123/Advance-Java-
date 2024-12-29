<%-- String uname = config.getInitParameter("uname"); --%>


<%= "Welcome : " + application.getInitParameter("uname") %>

<%
String uname  = request.getParameter("uname");
String pwd    = request.getParameter("pwd");
session.setAttribute("user", "System");
session.setAttribute("pwd", "abc@123");
%>

<%= session.getAttribute("pwd")%>