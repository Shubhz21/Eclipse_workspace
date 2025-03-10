<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello, this is JSTL</title>
</head>
<body>



<c:set var="score" value="10" scope="session"/>

<c:choose>
    <c:when test="${score > 70}">
        <p>B</p>
    </c:when>
    <c:when test="${score > 10}">
        <p>A</p>
    </c:when>
    <c:otherwise>
        <p>C</p>
    </c:otherwise>
</c:choose>
<c:forEach var="num" begin="0" end="10">
    <p>Number: ${num}</p>
</c:forEach>

</body>
</html>
