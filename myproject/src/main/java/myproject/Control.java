package myproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Control {
	
	public static void main(String a[]) {
		ApplicationContext app = new ClassPathXmlApplicationContext("springconfig.xml");
	Debitcard dc=(Debitcard)app.getBean("dbtcrd");
	
	dc.pay();
	
	}
	
	

}
