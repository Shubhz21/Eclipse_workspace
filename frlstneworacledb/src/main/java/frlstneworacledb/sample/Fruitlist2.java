package frlstneworacledb.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fruitlist2")  // Correct mapping
public class Fruitlist2 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String txt = request.getParameter("txt");

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish Connection
            con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XEPDB1", "shubham", "admin");
            
            // Prepare Query
            stmt = con.prepareStatement("SELECT * FROM FRUITS WHERE FRUITNAME = ?");
            stmt.setString(1, txt);
            
            // Execute Query
            rs = stmt.executeQuery();

            if (rs.next()) {
                pw.println("<br/><br/><br/><center><h2>Available quantity of " + rs.getString("FRUITNAME") + " is : " + rs.getInt("QUANTITY") + "</h2></center>");
            } else {
                pw.println("<center><h2>Data not Found</h2></center>");
            }

            // Redirect after 5 seconds
            pw.println("<script>");
            pw.println("setTimeout(function() { window.location.href = 'dtbsfetch.html'; }, 5000);");
            pw.println("</script>");

        } catch (ClassNotFoundException e) {
            pw.println("<center><h2>Database Driver Not Found</h2></center>");
            e.printStackTrace();
        } catch (SQLException e) {
            pw.println("<center><h2>Database Error: " + e.getMessage() + "</h2></center>");
            e.printStackTrace();
        } finally {
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
