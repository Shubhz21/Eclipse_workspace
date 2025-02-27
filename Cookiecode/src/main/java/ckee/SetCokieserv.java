package ckee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/readcke")
public class SetCokieserv extends HttpServlet {
	
       
    
    

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		PrintWriter p = res.getWriter();
		
		Cookie[] cks = req.getCookies();
		
		String user ="nodata";
		
		HttpSession s = req.getSession();
		
		p.println("session id: "+s.getId());
		
		if(cks != null) {
			
			for(Cookie ck : cks) {
				
				if(ck.getName().equals(req.getParameter("ckdt"))) {
					
					user = ck.getValue();
					
					break;
				}
				
				System.out.println("cookies  :"+ck.getValue());
				
			}
		}
		
		p.println("<h2>Stored Cookie Value: " + user + "</h2>");
		
		
		
		
		
		
		
	}

	
	

}
