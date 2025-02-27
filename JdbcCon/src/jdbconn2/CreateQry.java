package jdbconn2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateQry {

	public static void main(String[] args) throws SQLException {
		
System.out.println("\npls update data: \n");
		
//		Scanner s2= new Scanner(System.in);
//		
//	String	d1= s2.next();
//	String	d2= s2.next();

PreparedStatement pst3;


	    Connection c;
	    
	    ResultSet rs;
	    
	    String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String oracleUser = "system";
        String oraclePassword = "admin";
	    
	    
	    
	    c = DriverManager.getConnection(oracleUrl,oracleUser,oraclePassword);
	    
	    
	    
		
		pst3 = c.prepareStatement("create table sample (c1 varchar(50),c2 varchar(40),c3 varchar(50),c4 varchar(50))");
		
		
		c.createStatement();
		
//		pst3.setString(1,d1);
//		pst3.setString(2,d2);
		
		
	//	int rowsdata2 =  pst3.executeUpdate();
		
		pst3.execute();
		
		System.out.println("\n");
		
	//	System.out.println(rowsdata2+"rows updated");
		
	//	rs = st.executeQuery("select * from sample");
		
		System.out.println("\nTable created Successfully!");
		
//		System.out.println("+--------+----------+");
//        System.out.println("|  Name  |  Address |");
//        System.out.println("+--------+----------+");
		
//		while(rs.next()) {
//			//String data= rs.getString("name")+"  "+rs.getString("address");
//			
//			//System.out.println(data);
//			
//			String name=rs.getString("name");
//			
//			String addrs=rs.getString("address");
//			
//			System.out.printf("|%-8s| %-9s|\n",name,addrs);
//			
//			System.out.println("+-------------------+");
//			}
		
		

	}

	}


