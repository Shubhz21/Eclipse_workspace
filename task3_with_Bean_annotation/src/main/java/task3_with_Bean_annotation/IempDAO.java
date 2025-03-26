package task3_with_Bean_annotation;

import java.util.List;



public interface IempDAO {

	
	void addEmployee(Emp emp); 

    Emp getEmployee(Emp id); 

    List <Emp> getAllEmployees(); 

    void updateSalary(int id, int salary); 

    void deleteEmployee(int id); 
	
}
