<%@ page import="java.util.List, mypkg.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Employee List</title>
    <!-- <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding: 20px; }
        .container { width: 80%; background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px 0px gray; margin: auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border: 1px solid #ddd; text-align: center; }
        th { background-color: blue; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }
    </style> -->
</head>
<body>
    <div class="container">
        <h2>Registered Employees</h2>
        <table>
            <thead>
                <tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Salary</th><th>Dept ID</th></tr>
            </thead>
            <tbody>
                <% 
                List<Employee> empl = (List<Employee>) request.getAttribute("empl");
                if (empl != null) {
                    for (Employee emp : empl) { %>
                        <tr>
                            <td><%= emp.getEmpid() %></td>
                            <td><%= emp.getFname() %></td>
                            <td><%= emp.getLname() %></td>
                            <td><%= emp.getSalary() %></td>
                            <td><%= emp.getDeptid() %></td>
                        </tr>
                    <% }
                } else { %>
                    <tr><td colspan="5">No employees found.</td></tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
