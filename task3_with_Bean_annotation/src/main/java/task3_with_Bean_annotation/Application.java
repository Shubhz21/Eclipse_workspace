package task3_with_Bean_annotation;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        
        EmpS es = context.getBean(EmpS.class);

        
        es.getAllEmployees();
        es.updateSalary(1, 20000);
        es.deleteEmployee(1);
    }
}

