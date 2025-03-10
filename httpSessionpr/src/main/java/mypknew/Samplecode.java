package mypknew;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Samplecode extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Scanner s = new Scanner(System.in);
		
		int age;
		System.out.println("enetr value: ");
		
		age=s.nextInt();
	
	String myage= req.getParameter("age");
		
		
		
		
	}

	
	
	
}
