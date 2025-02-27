package jdbcconn1;

import java.sql.*;

public class Jdbcconn2 {

	public static void main(String[] args) throws SQLException {
		
		//oraclcon detailse
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String oracleUser = "system";
        String oraclePassword = "admin";

        // MySQL Database Connection Details
        String mysqlUrl = "jdbc:mysql://localhost:3306/fruitbasket";
        String mysqlUser = "root";
        String mysqlPassword = "admin";

        Connection oracleConn = DriverManager.getConnection(oracleUrl,oracleUser,oraclePassword);
        Connection mysqlConn = DriverManager.getConnection(mysqlUrl,mysqlUser,mysqlPassword);
        
        
        Statement st1 = oracleConn.createStatement();
        
        Statement st2 = mysqlConn.createStatement();
        
        ResultSet rs1,rs2 ;
        
        rs1= st1.executeQuery("select * from customer");
        rs2 = st2.executeQuery("select * from fruits");
        
        while(rs1.next()&&rs2.next()) {
        	
        	String data= rs1.getString("name")+"  "+rs1.getString("address")+"  "+rs2.getString("fruitname")+"  "+rs2.getString("quantity");
    		
    		System.out.println(data);
        	
        }
        
        
        

	}

}
