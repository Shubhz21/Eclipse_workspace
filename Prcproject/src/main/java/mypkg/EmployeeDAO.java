package mypkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String username = "system";
    private static final String password = "admin";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
    	
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        return DriverManager.getConnection(url, username, password);
        
    }

    public List<Employee> getAllemployee() throws ClassNotFoundException, SQLException {
    	
        List<Employee> empl = new ArrayList<>();
        
        String query = "SELECT empid, fname, lname, salary, deptid FROM empl";

        try (Connection connection = getConnection();
        		
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        		
        		
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
            	
                Employee emp = new Employee();
                
                emp.setEmpid(rs.getInt("empid"));
                emp.setFname(rs.getString("fname"));
                emp.setLname(rs.getString("lname"));
                emp.setSalary(rs.getInt("salary"));
                emp.setDeptid(rs.getInt("deptid"));
                empl.add(emp);
            }
        }
        return empl;
    }
}
