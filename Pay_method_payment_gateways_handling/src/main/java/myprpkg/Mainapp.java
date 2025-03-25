package myprpkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mainapp {
    public static void main(String[] args) {
        
      //  ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        ApplicationContext context2 = new AnnotationConfigApplicationContext(JavaConfig.class);
        
       // DebitCardPayment processor = (DebitCardPayment) context2.getBean("debitCardPayment");
        
        PaymentProcessor processor2 = (PaymentProcessor) context2.getBean("paymentProcessor");

        
        processor2.process();
        
    }
}
