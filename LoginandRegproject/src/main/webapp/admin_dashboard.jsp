<%@ page import="java.util.List, logreg.Adminandstudentmodel" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>

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
        
        .btn { padding: 5px 10px; text-decoration: none; color: white; border-radius: 5px; border: none; cursor: pointer; }
        
        .edit { background-color: green; }
        
        .delete { background-color: red; }
        
        .logout{ background-color: grey; }
        
    </style>
</head>
<body>
    <div class="container">
        <h2>Registered Students</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Username</th><th>Actions</th>
                </tr>
            </thead>
            <tbody>
            
            <%
            
    HttpSession sessionAdmin = request.getSession(false);
            
    if (sessionAdmin == null || sessionAdmin.getAttribute("username") == null || !"ADMIN".equals(sessionAdmin.getAttribute("role"))) {
    	
        response.sendRedirect("login.html?error=Please login first");
        
        return;
    }
%>
            
                <% List<Adminandstudentmodel> students = (List<Adminandstudentmodel>) request.getAttribute("students");
                   for (Adminandstudentmodel student : students) { %>
                <tr>
                    <td><%= student.getId()%></td>
                    <td><%= student.getName()%></td>
                    <td><%= student.getEmail()%></td>
                    <td><%= student.getPhone()%></td>
                    <td><%= student.getUsername()%></td>
                    <td>
                        <a href="EditStudentServlet?id=<%= student.getId() %>" class="btn edit">Edit</a> 	
                        <a href="DeleteStudentServlet?id=<%= student.getId() %>" class="btn delete" onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <br/>
    <a href="main.html" class="btn logout" >Logout</a>
</body>
</html>
