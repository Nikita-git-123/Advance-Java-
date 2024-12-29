<%! 
String s1 = "Hello...." ;
String s2 = "Nikuuuu" ;
%>

<%
int a = 10;
int b = 10;
int c = a + b ;
%>

<%= 
"String concat : " + s1 + s2 
%>

<%= " Sum " + c %>

<%   
  String userName =  request.getParameter("name");
  String pwd =  request.getParameter("pwd");
  
  if(userName.equals("Niku")){
	  response.sendRedirect("http://www.facebook.com");
  }
  else{
	  out.print("Invalid Credentials");
  }
%>