package logreg;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/register")
public class Studentsrvlt extends HttpServlet {
	
	
    private Studentdb studentdb;

    public void init() {
        studentdb = new Studentdb();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	
    	
    	
        
        int registerStudentId = 0;
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setUsername(username);
        student.setPassword(password);

        try {
            registerStudentId = studentdb.registerStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(registerStudentId > 0) {
            request.setAttribute("name", student.getName());
            request.setAttribute("email", student.getEmail());
            request.setAttribute("phone", student.getPhone());
            request.setAttribute("username", student.getUsername());
            request.setAttribute("password", student.getPassword());
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
            
            requestDispatcher.forward(request, response);
        } else {
        	
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("regerror.html");
            
            requestDispatcher.forward(request, response);
        }
    }
}

