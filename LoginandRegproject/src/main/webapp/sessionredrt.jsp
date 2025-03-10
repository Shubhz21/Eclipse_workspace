<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>


 


<% 

out.println("this is key from another page");

pageContext.getAttribute("name",PageContext.APPLICATION_SCOPE);

pageContext.getAttribute("name",PageContext.PAGE_SCOPE);

pageContext.getAttribute("name",PageContext.REQUEST_SCOPE);

pageContext.getAttribute("name",PageContext.REQUEST_SCOPE);

out.println(pageContext);

%>

<%
int age;
%>
${ param.age> 18 ?"Minor":"Adult" }


</body>
</html>