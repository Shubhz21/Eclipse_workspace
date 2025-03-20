package myproject;

public class Creditcard implements IcardPayment{
	
	
	 Creditcard() {
		System.out.println("Credit card cons");
	}

	public void pay() {
		
		System.out.println("This is pay method of credit card ");
		
	}
	
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	
}
