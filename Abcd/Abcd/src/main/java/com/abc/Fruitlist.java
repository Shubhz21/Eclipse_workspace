package com.abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Fruitlist extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		String txt = request.getParameter("txt");
				
				 Connection con=null;
				 
				 PreparedStatement stmt=null;
				 
				 ResultSet rs=null;
				
				
				 
				try {
				 
				 
				// Class.forName("com.mysql.cj.jdbc.Driver");
				 
				 Class.forName("oracle.jdbc.OracleDriver");
				 
				// con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitlist","root","admin");
				 
			//	 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","system", "admin");
				 
				 String url="jdbc:oracle:thin:@localhost:1521:xe";
				 String user="system";
				 String password="admin";
				 
				 con = DriverManager.getConnection(url,user,password);
				 
				 System.out.println("connected to oracle 10g XE successfully!");
				 
				 stmt = con.prepareStatement("select * from fruits where fruitname = ?");
				 
				 stmt.setString(1,txt);
				 
				 rs = stmt.executeQuery();
				 
				while(rs.next()){
					pw.println("<br/><br/><br/><center><h2>Available quantity of "+rs.getString(1)+" is : "+rs.getInt(2)+"</h2></center>");
				}
				 
				if (txt == null || txt.isEmpty()) {
		            pw.println("<center><h2 style='color:red;'>Invalid Input! Please enter both fruit name and quantity.</h2></center>");
		            
		            pw.println("<script>");
		            pw.println("setTimeout(function() {");
		            pw.println("window.location.href = 'dtbsfetch.html';"); // Redirect to a new page (e.g., 'index.jsp')
		            pw.println("}, 5000);"); // 5000 milliseconds = 5 seconds
		            pw.println("</script>");
		            
		            return;
		            
		            
		        }
				 
				
				
				
				
				 pw.println("<script>");
		            pw.println("setTimeout(function() {");
		            pw.println("window.location.href = 'dtbsfetch.html';"); // Redirect to a new page (e.g., 'index.jsp')
		            pw.println("}, 5000);"); // 5000 milliseconds = 5 seconds
		            pw.println("</script>");
		            //con.close();
				
				 }
				catch(InputMismatchException e)
				 {
					 pw.println("<center><h2>Invalid Data..!</h2></center>");
					 
				 }
				catch(SQLException p) {
					
					 pw.println("<center><h2>Data not Found</h2></center>");
					 pw.println("<script>");
			            pw.println("setTimeout(function() {");
			            pw.println("window.location.href = 'dtbsfetch.html';"); // Redirect to a new page (e.g., 'index.jsp')
			            pw.println("}, 5000);"); // 5000 milliseconds = 5 seconds
			            pw.println("</script>");
			            
				 } catch (ClassNotFoundException e) {
					
					e.printStackTrace();
					System.err.println(e);
					
				}
				
				finally {
		            // Close resources
		            try {
		                if (rs != null) rs.close();
		                if (stmt != null) stmt.close();
		                if (con != null) con.close();
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
				
				
	}

}
