package mypknew;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Dashbrdsrvlt extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		
		PrintWriter p = res.getWriter();
		
		HttpSession session = req.getSession(false);
		
		if(session != null && session.getAttribute("user")!=null) {
			String uname = (String) session.getAttribute("user");
			p.println("<h2>welcome to dashboard,"+uname+"!</h2>");
			p.println("<a href='Logoutsrvlt'>Logout<a/>");
		} else {
			p.println("<h2>No active session found. Please <a href='login.html'>Login </a></h2>");
		}
		
		
	}

	
	

}
