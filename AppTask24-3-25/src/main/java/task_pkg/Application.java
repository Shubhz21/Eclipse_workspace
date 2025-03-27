package task_pkg;

public class Application {
    public static void main(String[] args) {
    	
        EmployeeService service = new EmployeeService(new EmployeeDAOImpl());

        service.addEmployee(new Employee(0, "Rushi", "Manager", 100000));
        
        service.getAllEmployees();
        
       // service.getEmployee(2);
        
       // service.deleteEmployee(1);
        
       // service.updateSalary(2, 20000);
        
       
    }
}
