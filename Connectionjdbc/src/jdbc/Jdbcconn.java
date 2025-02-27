package jdbc;



import java.sql.*;

public class Jdbcconn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="admin";
		
		Connection con= DriverManager.getConnection(url,username,password);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from fruits");
		
		while(rs.next()) {
			String name = rs.getString("fruitname")+" "+rs.getString("quantity");
			
			System.out.println(name);
			
		}
		
		st.close();
		con.close();
		

	}

}
