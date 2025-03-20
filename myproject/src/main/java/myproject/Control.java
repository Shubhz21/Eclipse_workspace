package myproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Control {
	
	
	public static void main(String a[]) {
		
		
		ApplicationContext app = new ClassPathXmlApplicationContext("springconfig.xml");
		
		
	    Debitcard dc=(Debitcard)app.getBean("dbtcrd");
	    Creditcard cc =(Creditcard)app.getBean("crdtcrd");
	
	dc.pay();
	
	
	
	dc.setName("shubham");
	
	System.out.println("this is first obj "+dc.getName());
	
	Debitcard debc = (Debitcard)app.getBean("dbtcrd");
	
	//debc.setName("kalyani");
	
	
	System.out.println("this is first obj "+dc.getName());
	
	System.out.println("this is second obj "+debc.getName());
	
	
	debc.getAddress();
	
	
	}

}
