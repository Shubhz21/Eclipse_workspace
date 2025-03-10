<%@ page import="java.util.List, logreg.Adminandstudentmodel" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Admin Dashboard - Student List</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding: 20px; }
        .container { width: 80%; background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px 0px gray; margin: auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border: 1px solid #ddd; text-align: center; }
        th { background-color: blue; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registered Students</h2>
        <table>
            <thead>
                <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Username</th></tr>
            </thead>
            <tbody>
                <% List<Adminandstudentmodel> students = (List<Adminandstudentmodel>) request.getAttribute("students");
                   for (Adminandstudentmodel student : students) { %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getPhone() %></td>
                    <td><%= student.getUsername() %></td>
                </tr>
                <% } %>
                
            </tbody>
        </table>
    </div>
</body>
</html>
