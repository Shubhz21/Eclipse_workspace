package logreg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Loginandregdao {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    
    private static final String USERNAME = "system";
    
    private static final String PASSWORD = "admin";

    private Connection connection;

    
    public Loginandregdao() {
    	
        try {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }
    }

    
    public int registerUser(Adminandstudentmodel aorstmodel) {
    	
        String INSERT_USER_SQL = "INSERT INTO uRegister (id, name, email, phone, username, password, role) VALUES (uRegister_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
        	
            preparedStatement.setString(1, aorstmodel.getName());
            
            preparedStatement.setString(2, aorstmodel.getEmail());
            
            preparedStatement.setString(3, aorstmodel.getPhone());
            
            preparedStatement.setString(4, aorstmodel.getUsername());
            
            preparedStatement.setString(5, aorstmodel.getPassword());
            
            preparedStatement.setString(6, aorstmodel.getRole());

            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        	
            printSQLException(e);
        }
        return result;
    }

    
    public String validateUser(String username, String password) {
    	
        String role = null;
        
        String LOGIN_SQL = "SELECT role FROM uRegister WHERE username = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
        	
            preparedStatement.setString(1, username);
            
            preparedStatement.setString(2, password);
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	
                role = rs.getString("role");
            }
        } catch (SQLException e) {
        	
            printSQLException(e);
            
        }
        
        return role;
    }

    
    public List<Adminandstudentmodel> getAllStudents() {
    	
        List<Adminandstudentmodel> students = new ArrayList<>();
        
        String FETCH_STUDENTS_SQL = "SELECT id, name, email, phone, username FROM uRegister WHERE role = 'STUDENT'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(FETCH_STUDENTS_SQL);
        		
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
            	
                Adminandstudentmodel student = new Adminandstudentmodel();
                
                student.setId(rs.getInt("id"));
                
                student.setName(rs.getString("name"));
                
                student.setEmail(rs.getString("email"));
                
                student.setPhone(rs.getString("phone"));
                
                student.setUsername(rs.getString("username"));
                
                students.add(student);
            }
        } catch (SQLException e) {
        	
            printSQLException(e);
            
        }
        return students;
    }

    
    public void updateStudent(Adminandstudentmodel student) {
        String UPDATE_SQL = "UPDATE uRegister SET name=?, email=?, phone=?, username=? WHERE id=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE_SQL)) {
        	
            stmt.setString(1, student.getName());
            
            stmt.setString(2, student.getEmail());
            
            stmt.setString(3, student.getPhone());
            
            stmt.setString(4, student.getUsername());
            
            stmt.setInt(5, student.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    
    public void deleteStudent(int id) {
        String DELETE_SQL = "DELETE FROM uRegister WHERE id=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(DELETE_SQL)) {
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
        	
            printSQLException(e);
            
        }
    }

    
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Adminandstudentmodel getStudentById(int id) throws ClassNotFoundException, SQLException {
        String QUERY = "SELECT id, name, email, phone, username FROM uRegister WHERE id=?";
        Adminandstudentmodel student = null;

        try (PreparedStatement stmt = connection.prepareStatement(QUERY)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Adminandstudentmodel();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setUsername(rs.getString("username"));
            }
        }
        return student;
    }
    
    

    
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable error = ex.getCause();
                while (error != null) {
                    System.out.println("Cause: " + error);
                    error = error.getCause();
                }
            }
        }
    }
}
