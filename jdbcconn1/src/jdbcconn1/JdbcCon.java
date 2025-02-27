package jdbcconn1;

import java.sql.*;
import java.util.Scanner;

public class JdbcCon {

	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		
		String d1,d2;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="admin";
		
		
		Connection c = DriverManager.getConnection(url,username,password);
		
		Statement st = c.createStatement();
		
		ResultSet rs;
		
		rs = st.executeQuery("select * from customer");
		
		
		while(rs.next()) {
		String data= rs.getString("name")+"  "+rs.getString("address");
		
		System.out.println(data);
		}
		
		System.out.println("\npls insert data: \n");
		
		Scanner s= new Scanner(System.in);
		
		d1= s.next();
		d2= s.next();
		
		
		PreparedStatement pst2 = c.prepareStatement("INSERT INTO customer (name, address) VALUES (?, ?)");
		
		pst2.setString(1,d1);
		pst2.setString(2,d2);
		
		
		int rowsdata =  pst2.executeUpdate();
		
		System.out.println("\n");
		
		System.out.println(rowsdata+" rows inserted");
		
		rs= st.executeQuery("select * from customer");
		
		System.out.println("\n");
		
		while(rs.next()) {
			String data= rs.getString("name")+"  "+rs.getString("address");
			
			System.out.println(data);
			}
		
		
		
		
		

	}

}
