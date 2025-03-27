package projectnew;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class EmployeeService {
	
    private IEmployeeDAO employeeDAO;
    
    
    public void displayEmployee(int id) {
    	
        Employee emp = employeeDAO.getEmployee(id);
        
        if (emp != null) {
            System.out.println("----------------------------------------------------------");
            System.out.printf("| %-5s | %-15s | %-15s | %-10s |\n", "ID", "Name", "Department", "Salary");
            System.out.println("----------------------------------------------------------");
            System.out.printf("| %-5d | %-15s | %-15s | %-10d |\n", emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
    
    
    public void displayEmployeeswithUpdated() {
        List<Employee> employees = employeeDAO.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-5s | %-15s | %-15s | %-10s |\n", "ID", "Name", "Department", "Salary");
        System.out.println("----------------------------------------------------------");

        
        for (Employee emp : employees) {
            System.out.printf("| %-5d | %-15s | %-15s | %-10d |\n",
                    emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
        }
        
        System.out.println("----------------------------------------------------------");
    }
    
    

    @Autowired
    public EmployeeService(IEmployeeDAO employeeDAO) {
    	
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee emp) {
        employeeDAO.addEmployee(emp);
        
        displayEmployeeswithUpdated();
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    
    public void displayAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-5s | %-15s | %-15s | %-10s |\n", "ID", "Name", "Department", "Salary");
        System.out.println("----------------------------------------------------------");

        
        for (Employee emp : employees) {
            System.out.printf("| %-5d | %-15s | %-15s | %-10d |\n",
                    emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
        }
        
        System.out.println("----------------------------------------------------------");
    }
    
    

    public void updateSalary(int id, int salary) {
        employeeDAO.updateSalary(id, salary);
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}

