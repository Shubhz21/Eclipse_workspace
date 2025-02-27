package logreg;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Logindb {

    public boolean validate(Loginstd loginstd) throws ClassNotFoundException {
    	
        boolean status = false;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
        		
            
            PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM uregister WHERE username = ? AND password = ?")) {
            preparedStatement.setString(1, loginstd.getUsername());
            preparedStatement.setString(2, loginstd.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            status = rs.next();

        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

