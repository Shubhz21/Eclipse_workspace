package mypkg;

import java.sql.SQLException;
import java.util.List;

public class Empservice  {
	
	private EmployeeDAO empdao;

	
    public Empservice() {
    	
        empdao = new EmployeeDAO();  
        
    }
    public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
        return empdao.getAllemployee(); 
    }

	
	
}
