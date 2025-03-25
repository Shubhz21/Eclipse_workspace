package projectnew;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;



public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext cont = new AnnotationConfigApplicationContext(Config.class);
		
		EmployeeService es = (EmployeeService) cont.getBean("employeeService");
		
		
		es.addEmployee(null);
		es.getEmployee(1);
		es.getAllEmployees();
		es.updateSalary(1, 20000);
		es.deleteEmployee(1);
	}
	
	
}
