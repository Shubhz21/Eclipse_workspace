package myproject;

public class Debitcard implements IcardPayment {
	
	 Debitcard() {
	
		 System.out.println("This is debitcard section");
	}

	public void pay() {
		
		System.out.println("this is pay method of debitcard");
		
	}
	
	private String name;
	private int number;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	private Address add;


	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}
	
	
	
	public void getAddress() {
		
		System.out.println(add.toString());
	}
	
	
	

	

}
