package logreg;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Loginandregdao {

    private static final String  url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String username = "system";
    private static final String password = "admin";

    
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, username, password);
    }

    
    public int registerUser(Adminandstudentmodel aorstmodel) throws ClassNotFoundException {
        String INSERT_USER_SQL = "INSERT INTO uRegister (id, name, email, phone, username, password, role) VALUES (uRegister_seq.NEXTVAL,?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, aorstmodel.getName());
            preparedStatement.setString(2, aorstmodel.getEmail());
            preparedStatement.setString(3, aorstmodel.getPhone());
            preparedStatement.setString(4, aorstmodel.getUsername());
            preparedStatement.setString(5, aorstmodel.getPassword());
            preparedStatement.setString(6, aorstmodel.getRole()); // Either "STUDENT" or "ADMIN"

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    
    public String validateUser(String username, String password) throws ClassNotFoundException {
        String role = null;
        String LOGIN_SQL = "SELECT role FROM uRegister WHERE username = ? AND password = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                role = rs.getString("role"); // Get User Role
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return role; // Returns "STUDENT", "ADMIN", or null if invalid login
    }
    
    
    
    public List<Adminandstudentmodel> getAllStudents() throws ClassNotFoundException, SQLException {
    	
    	
    	
        List<Adminandstudentmodel> students = new ArrayList<>();
        String FETCH_STUDENTS_SQL = "SELECT id, name, email, phone, username FROM uRegister WHERE role = 'STUDENT'";

        Connection connection = getConnection();
        
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

