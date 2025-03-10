<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Members</title>
</head>
<body>

<h2>Student List</h2>

    <ul>
        <c:forEach var="student" items="${stdList}">
            <li>${student}</li>
        </c:forEach>
    </ul>

</body>
</html>