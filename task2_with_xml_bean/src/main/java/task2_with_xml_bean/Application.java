package task2_with_xml_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        
        EmpS es = context.getBean("empservice", EmpS.class);

        
        es.getAllEmployees();
        es.updateSalary(1, 20000);
        es.deleteEmployee(1);
    }
}
