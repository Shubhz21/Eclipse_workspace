package mynewpkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		BankReg bnkreg = (BankReg) context.getBean("bankReg");
		
		
		bnkreg.task();
		
	}
	
	
	
	
	
	

}
