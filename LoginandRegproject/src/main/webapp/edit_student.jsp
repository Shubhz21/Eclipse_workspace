<%@ page import="logreg.Adminandstudentmodel" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Edit Student</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; background: #f4f4f4; padding: 20px; }
        .container { width: 50%; background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px gray; margin: auto; }
        .input-field { width: 100%; padding: 10px; margin: 10px 0; }
        .btn { padding: 10px 20px; background: green; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Edit Student</h2>
        <form action="UpdateStudentServlet" method="post">
            <% Adminandstudentmodel student = (Adminandstudentmodel) request.getAttribute("student"); %>
            <input type="hidden" name="id" value="<%= student.getId() %>">
            <input type="text" name="name" value="<%= student.getName() %>" class="input-field" required>
            <input type="email" name="email" value="<%= student.getEmail() %>" class="input-field" required>
            <input type="text" name="phone" value="<%= student.getPhone() %>" class="input-field" required>
            <input type="text" name="username" value="<%= student.getUsername() %>" class="input-field" required>
            <button type="submit" class="btn">Update</button>
        </form>
    </div>
</body>
</html>
