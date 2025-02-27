package jdbconn2;

import java.sql.*;

public class JdbcCon3 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change if needed
        String user = "system";  // Replace with your Oracle username
        String password = "admin"; // Replace with your Oracle password

        Connection conn = null;
        Statement stmt = null;
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Oracle Database!");

            
            stmt = conn.createStatement();

            String[] sqlCommands = {
            		"create table uLogin (empid int,fname varchar(50),lname varchar(50),salary int,deptid int,hiredate date)",
            };

            
            for (String sql : sqlCommands) {
                stmt.executeUpdate(sql);
                System.out.println("Executed: " + sql);
            }

            System.out.println("All queries executed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 6. Close resources
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


