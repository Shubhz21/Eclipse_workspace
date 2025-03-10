package logreg;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




//@WebServlet("/login")
public class Loginsrvlt extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    private Logindb logindb;

    public void init() {
    	logindb = new Logindb();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	
    	
        String username = request.getParameter("username");
        
        String password = request.getParameter("password");
        
        Loginstd loginstd = new Loginstd();
        
        loginstd.setUsername(username);
        
        loginstd.setPassword(password);

        try {
            if (logindb.validate(loginstd)) {
                HttpSession session = request.getSession();
                  session.setAttribute("username",username);
                response.sendRedirect("welcome.html");
            } else {
            	
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("error.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
}
