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



session.setAttribute("key","shubham");

pageContext.setAttribute("name","shubham",pageContext.APPLICATION_SCOPE);

pageContext.setAttribute("name","shubham",pageContext.PAGE_SCOPE);

pageContext.setAttribute("name","shubham",pageContext.REQUEST_SCOPE);

pageContext.setAttribute("name","shubham",pageContext.SESSION_SCOPE);


response.sendRedirect("sessionredrt.jsp");
%>



</body>
</html>