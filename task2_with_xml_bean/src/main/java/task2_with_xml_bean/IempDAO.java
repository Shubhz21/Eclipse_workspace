package task2_with_xml_bean;

import java.util.List;


public interface IempDAO {

	
	void addEmployee(Emp emp); 

    Emp getEmployee(Emp id); 

    List<Emp> getAllEmployees(); 

    void updateSalary(int id, int salary); 

    void deleteEmployee(int id); 
}
