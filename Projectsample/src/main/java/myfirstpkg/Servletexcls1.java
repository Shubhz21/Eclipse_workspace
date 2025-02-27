package myfirstpkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servletexcls1")
public class Servletexcls1 extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet is initializing...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get data from the request
        String name = request.getParameter("username");

        // Print response
        out.println("<html><body>");
        out.println("<h2>Hello, " + name + "! Welcome to the servlet response.</h2>");
        out.println("</body></html>");

        System.out.println("Processing request for: " + name);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is being destroyed...");
    }
}
