package logreg;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Studentdb {

    public int registerStudent(Student student) throws ClassNotFoundException {
    	
        String INSERT_USERS_SQL = "INSERT INTO uRegister1" +
                "  (name, email, phone, username, password) VALUES " +
                " (?, ?, ?, ?, ?)";

        int result = 0;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

            
        		
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        	
            preparedStatement.setString(1, student.getName());
            
            preparedStatement.setString(2, student.getEmail());
            
            preparedStatement.setString(3, student.getPhone());
            
            preparedStatement.setString(4, student.getUsername());
            
            preparedStatement.setString(5, student.getPassword());
            

            
            result = preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
           
            printSQLException(e);
        }
        
        
        return result;
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

