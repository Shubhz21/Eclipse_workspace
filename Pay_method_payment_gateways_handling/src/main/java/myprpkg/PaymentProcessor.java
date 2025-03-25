package myprpkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {
	
	private CardPayment creditCard;
	private CardPayment debitCard;
	
	
	public PaymentProcessor() {
		
        System.out.println("PaymentProcessor default constructor called");
    }
	
	@Autowired 
	PaymentProcessor(@Qualifier("debitCardPayment") CardPayment crd){
		
		this.creditCard=crd;
	}
	

	
	
	
	
	public void setCreditCard(CardPayment creditCard) {
        this.creditCard = creditCard;
    }
	
	
	public void setDebitCard(CardPayment debitCard) {
        this.debitCard = debitCard;
    }
	
	
	public void process() {
        System.out.println("Initiating payment processing...");
        
        if (creditCard != null) {
            creditCard.paymentProcess();
        }
        
        if (debitCard != null) {
            debitCard.paymentProcess();
        }
        
        System.out.println("Payment processing completed.");
    }
}
