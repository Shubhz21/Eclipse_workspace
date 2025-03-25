package projectnew;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	  

    public EmployeeDAOImpl(){
    	
        System.out.println("empdao cons called...");
    }

    
    public void addEmployee(Employee emp) {
    	
    	System.out.println("emp added");
        
    }

    
    public Employee getEmployee(int id) {
    	
    	System.out.println("emp viewed");
    	
        return null;
    }

    
    public List<Employee> getAllEmployees() {
    	
    	System.out.println("all emp's");
        
        return null;
    }

    
    public void updateSalary(int id, int salary) {
    	
    	System.out.println("slry updated");
    }

    
    public void deleteEmployee(int id) {
        
    	System.out.println("emp dltd");
    }
}
