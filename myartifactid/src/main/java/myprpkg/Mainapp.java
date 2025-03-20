package myprpkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainapp {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        
        PaymentProcessor processor = (PaymentProcessor) context.getBean("paymentProcessor");

        
        processor.process();
    }
}
