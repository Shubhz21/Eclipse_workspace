package mynewpkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BankReg {
	
	private MandatoryTasks tasks;
	
	public BankReg() {
		System.out.println("Default cons called...");
	}
	
	@Autowired
	BankReg(@Qualifier("bank") MandatoryTasks t){
		
		this.tasks=t;
		
	}
	
	
	public void task() {
		
		try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.out.println("Thread interrupted: " + e.getMessage());
        }
		
		
        System.out.println("Initiating Kyc process...");
        
        if (tasks != null) {
        	tasks.kyC();
        }
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        
        
        System.out.println("Process completed.");
    }
	

}
