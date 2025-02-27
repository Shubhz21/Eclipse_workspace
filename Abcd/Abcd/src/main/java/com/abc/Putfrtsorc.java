package com.abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Putfrtsorc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        
        String fruitname = request.getParameter("fruitname");
        String quantityStr = request.getParameter("quantity");

        
        if (fruitname == null || fruitname.isEmpty() || quantityStr == null || quantityStr.isEmpty()) {
            pw.println("<center><h2 style='color:red;'>Invalid Input! Please enter both fruit name and quantity.</h2></center>");
            
            pw.println("<script>");
            pw.println("setTimeout(function() {");
            pw.println("window.location.href = 'dtbspost.html';"); // Redirect to a new page (e.g., 'index.jsp')
            pw.println("}, 5000);"); // 5000 milliseconds = 5 seconds
            pw.println("</script>");
            
            return;
            
            
        }

        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            pw.println("<center><h2 style='color:red;'>Invalid Quantity! Please enter a numeric value.</h2></center>");
            return;
        }

        
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system";
            String password = "admin";

            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Oracle 10g XE successfully!");

            
            String query = "INSERT INTO fruits (fruitname, quantity) VALUES (?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, fruitname);
            stmt.setInt(2, quantity);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                pw.println("<center><h2 style='color:green;'>Fruit added successfully!</h2></center>");
            } else {
                pw.println("<center><h2 style='color:red;'>Failed to add fruit. Try again.</h2></center>");
            }
        
            
            pw.println("<script>");
            pw.println("setTimeout(function() {");
            pw.println("window.location.href = 'dtbspost.html';"); 
            pw.println("}, 5000);");
            pw.println("</script>");
            
		
		 
            
        } catch (SQLException e) {
            e.printStackTrace();
            pw.println("<center><h2 style='color:red;'>Database Error: " + e.getMessage() + "</h2></center>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<center><h2 style='color:red;'>Driver Not Found!</h2></center>");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
