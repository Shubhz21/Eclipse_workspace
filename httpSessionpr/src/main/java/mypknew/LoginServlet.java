package mypknew;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{
       
    
    

	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		PrintWriter p = res.getWriter();
		
		
		
		HttpSession session = req.getSession();
		
		String uname = req.getParameter("username");
		
		session.setAttribute("user", uname);
		
		
		
		p.println("<h2>Login Successful! Welcome, " + uname + "</h2>");
		p.println("<a href='Dashbrdsrvlt'>Go to Dashboard</a>");
		
		
		
	}

	
	
	
}
