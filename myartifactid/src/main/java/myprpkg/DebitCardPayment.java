package myprpkg;

import org.springframework.stereotype.Component;

@Component
public class DebitCardPayment  implements CardPayment {

	
	public void paymentProcess() {
		
		System.out.println("Process of payment using Debit card please wait.....!!");
			
		}
	
}
