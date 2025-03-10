<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String age= request.getParameter("a");


int a;
a = Integer.parseInt(age);

 if(a>18) {
	 out.println("age is above 18");
	 response.sendRedirect("sample2.jsp");
 }
 else{
	 out.println("age is below 18");
 } 
 
 
 
 
 %>

</body>
</html>