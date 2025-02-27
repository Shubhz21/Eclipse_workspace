package mypknew;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Logoutsrvlt extends HttpServlet {

       
   
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter p = response.getWriter();

       
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            p.println("<h2>You have been logged out.</h2>");
        } else {
            p.println("<h2>No active session found.</h2>");
        }
        p.println("<a href='login.html'>Login Again</a>");
	}

	
	

}
