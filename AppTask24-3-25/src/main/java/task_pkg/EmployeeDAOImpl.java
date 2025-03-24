package task_pkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements IEmployeeDAO {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    
    private static final String USER = "system"; 
    
    private static final String PASSWORD = "admin"; 

    public EmployeeDAOImpl(){
    	
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee emp) {
    	
        String sql = "INSERT INTO employees (id,name, department, salary) VALUES (empseq.nextval,?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        		
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
            
            System.out.println("Employee added successfully: ");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              int Id =  rs.getInt("id");
             String  Name = rs.getString("name");
             String dept  =  rs.getString("department");
              int salary =  rs.getInt("salary");
              
              System.out.printf("| %-16s| %-11s| %-10s| %-19s|\n",Id,Name,dept,salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        
        String sql = "SELECT * FROM employees";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        		
             Statement stmt = conn.createStatement();
        		
             ResultSet rs = stmt.executeQuery(sql)) {
        	
        	while (rs.next()) {
                int Id =  rs.getInt("id");
               String  Name = rs.getString("name");
               String dept  =  rs.getString("department");
                int salary =  rs.getInt("salary");
                
                System.out.printf("| %-16s| %-11s| %-10s| %-19s|\n",Id,Name,dept,salary);
              }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateSalary(int id, int salary) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setDouble(1, salary);
            
            stmt.setInt(2, id);
            
            stmt.executeUpdate();
            
            
            System.out.println("Salary updated for Employee ID " + id);
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        		
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
            System.out.println("Employee deleted: ID " + id);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
