package myprpkg;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements CardPayment{

	public void paymentProcess() {
		
		
	System.out.println("Process of payment using Credit card please wait.....");
		
	}

	
	
}
