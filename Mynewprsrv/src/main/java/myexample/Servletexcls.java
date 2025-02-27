package myexample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//@WebServlet(name = "Servletcls", urlPatterns = { "/Servletcls" })
public class Servletexcls implements Servlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
        System.out.println("Servlet is initializing...");
    }
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet is being destroyed...");
	}


	
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}



	
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}



	public void init(ServletConfig arg0) throws ServletException {
		
		
	}



	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
        PrintWriter demo = res.getWriter();
        demo.println("<h2>Hello, Servlet is working!</h2>");
        
       
        String name = req.getParameter("username");

        
        demo.println("<html><body>");
        demo.println("<h2>Hello, " + name + "! Welcome to the servlet response.</h2>");
        demo.println("</body></html>");

        System.out.println("Processing request for: " + name);
		
	}

}
