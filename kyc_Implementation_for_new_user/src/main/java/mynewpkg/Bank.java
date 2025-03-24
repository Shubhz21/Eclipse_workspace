package mynewpkg;

import org.springframework.stereotype.Component;

@Component
public class Bank implements MandatoryTasks{

	public void kyC() {
		
		try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.out.println("Thread interrupted: " + e.getMessage());
        }
		
		System.out.println("New user Details received..");
		
		
		try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.out.println("Thread interrupted: " + e.getMessage());
        }
		
		
		System.out.println("Details has been verified...Kyc was successfull..!");
		
	}
	
	

}
