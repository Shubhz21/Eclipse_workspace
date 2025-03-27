package projectnew;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;



public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext cont = new AnnotationConfigApplicationContext(Config.class);
		
		EmployeeService es = (EmployeeService) cont.getBean("employeeService");
		
		Employee e= new Employee();
		
		e.setDepartment("Jack");
		e.setId(86);
		e.setName("Cook");
		e.setSalary(75000);
		
		//es.addEmployee(e);
		
		//es.displayAllEmployees();
		
		//es.deleteEmployee(0);
		
		//es.updateSalary(0, 0);
	}
	
	
}
