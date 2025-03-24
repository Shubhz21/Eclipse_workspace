package myprpkg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("myprpkg")
public class JavaConfig {
	
	
	public DebitCardPayment debitcard() {
		
		
		return new DebitCardPayment();
		
	}
	


}
