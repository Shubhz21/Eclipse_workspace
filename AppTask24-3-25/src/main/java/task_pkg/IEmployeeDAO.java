package task_pkg;

import java.util.List;

public interface IEmployeeDAO {
	
	void addEmployee(Employee emp); 

    Employee getEmployee(int id); 

    List<Employee> getAllEmployees(); 

    void updateSalary(int id, int salary); 

    void deleteEmployee(int id); 
	
	

}
