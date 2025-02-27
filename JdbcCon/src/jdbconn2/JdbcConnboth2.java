package jdbconn2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnboth2 {

	public static void main(String[] args) throws SQLException {
		
		//oraclcon details
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String oracleUser = "system";
        String oraclePassword = "admin";

        // MySQL Database Connection Details
        String mysqlUrl = "jdbc:mysql://localhost:3306/fruitlist";
        String mysqlUser = "root";
        String mysqlPassword = "admin";

        Connection oracleConn = DriverManager.getConnection(oracleUrl,oracleUser,oraclePassword);
        
        Connection mysqlConn = DriverManager.getConnection(mysqlUrl,mysqlUser,mysqlPassword);
        
        Statement st3 = oracleConn.createStatement();
        
        PreparedStatement pst1=null;
        
        Statement st2 = mysqlConn.createStatement();
        
		ResultSet rs2, rs1;
        
		String[] qrs= {"insert into customer (name,address) values ('abhijeet','Pune')","select * from customer",};
		
		
		for(String qr: qrs) {
		
			st3 = oracleConn.createStatement();
		    st3.executeUpdate(qr);
		    System.out.println("Query executed: " + qr);
		    
		}
		
		rs1 = st3.executeQuery("select * from customer");
		
        rs2 = st2.executeQuery("select * from fruits");
        
        System.out.println("+-------------------+-----------+------------+");
        
        System.out.println("\n+-------------------+-----------+------------+");
        System.out.println("|   Name  | Address | Fruitname |  Quantity  |");
        System.out.println("+-------------------+-----------+------------+");
        
        while(rs1.next()&&rs2.next()) {
        	
        	//String data= rs1.getString("name")+"  "+rs1.getString("address")+"  "+rs2.getString("fruitname")+"  "+rs2.getString("quantity");
    		
        	String name=rs1.getString("name");
        	String addr=rs1.getString("address");
        	String fruitnm=rs2.getString("fruitname");
        	String qntty=rs2.getString("quantity");
        	
    		//System.out.println(data);
    		
    		System.out.printf("| %-6s | %-8s| %-10s| %-11s|\n",name,addr,fruitnm,qntty);
    		System.out.println("+-----------------+-----------+------------+");
        	
        }
        
        
        

	}

}
