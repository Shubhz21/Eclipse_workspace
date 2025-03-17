package logreg;



import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class Loginandregsrvlt extends HttpServlet {

    private Loginandregdao loginandregdao;

    public void init() {
    	loginandregdao = new Loginandregdao();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("register".equals(action)) {
        	
            registerUser(request, response);
            
        } else if ("login".equals(action)) {
        	
            loginUser(request, response);
            
        } else {
        	
            response.sendRedirect("error.html");
            
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int registerUserId = 0;
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role").toUpperCase(); // Get role (ADMIN/STUDENT)

        Adminandstudentmodel andst = new Adminandstudentmodel();
        
        andst.setName(name);
        andst.setEmail(email);
        andst.setPhone(phone);
        andst.setUsername(username);
        andst.setPassword(password);
        andst.setRole(role); // Assign the role

        try {
            registerUserId = loginandregdao.registerUser(andst);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (registerUserId > 0) {
        	
            request.setAttribute("name", andst.getName());
            request.setAttribute("email", andst.getEmail());
            request.setAttribute("phone", andst.getPhone());
            request.setAttribute("username", andst.getUsername());
            request.setAttribute("password", andst.getPassword());
            request.setAttribute("role", andst.getRole());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("regerror.html");
            requestDispatcher.forward(request, response);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            String role = loginandregdao.validateUser(username, password);

            if (role != null) {
                HttpSession session = request.getSession(); 
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                session.setMaxInactiveInterval(5 * 60); 

                if ("ADMIN".equals(role)) {
                    List<Adminandstudentmodel> students = loginandregdao.getAllStudents();
                    request.setAttribute("students", students);
                    request.getRequestDispatcher("admin_dashboard.jsp").forward(request, response);
                } else if ("STUDENT".equals(role)) {
                    response.sendRedirect("welcome.html");
                }
            } else {
                response.sendRedirect("error.html"); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    private void editStudent(HttpServletRequest request, HttpServletResponse response)
    
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");

        Adminandstudentmodel student = new Adminandstudentmodel();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setUsername(username);

        try {
            loginandregdao.updateStudent(student);
            response.sendRedirect("Loginandregsrvlt?action=login"); // Reload admin dashboard
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
    
}

