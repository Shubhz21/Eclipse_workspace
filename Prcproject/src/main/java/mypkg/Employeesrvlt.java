package mypkg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/abc")
public class Employeesrvlt extends HttpServlet {
    
    private Empservice empservice;

    
    public void init() {
        empservice = new Empservice();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
        try {
        	
            List<Employee> employees = empservice.getAllEmployees(); 
            
            req.setAttribute("empl", employees); 	
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("emp.jsp");
            
            dispatcher.forward(req, res); 
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving Employees.");
        }
    }
}
