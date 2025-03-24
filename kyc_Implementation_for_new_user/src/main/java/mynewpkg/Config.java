package mynewpkg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("mynewpkg")
public class Config {
	
	
public Bank bank() {
		
		
		return new Bank();
		
	}

}
