package myprpkg;

public class PaymentProcessor {
	
	private CardPayment creditCard;
	private CardPayment debitCard;
	
	
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
