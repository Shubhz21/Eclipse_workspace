package mypkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Mycls extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		
		
		res.setContentType("text/html");
        PrintWriter demo = res.getWriter();
        demo.println("<h2>Hello, Servlet is working!</h2>");
        
       
        String name = req.getParameter("username");

        
        demo.println("<html><body>");
        demo.println("<h2>Hello, " + name + "! Welcome to the servlet  get response.</h2>");
        demo.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		PrintWriter demo = res.getWriter();

		
 String postname = req.getParameter("username2");
        
 demo.println("<html><body>");
 demo.println("<h2>Hello, " + postname + "! Welcome to the servlet post response.</h2>");
 demo.println("</body></html>");

        System.out.println("Processing request for: " + postname);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
