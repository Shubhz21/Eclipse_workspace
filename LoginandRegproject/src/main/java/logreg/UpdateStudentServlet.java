package logreg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Loginandregdao loginandregdao;

    public void init() {
        loginandregdao = new Loginandregdao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        loginandregdao.updateStudent(student);

        response.sendRedirect("AdminDashboardServlet"); // Redirect to student list
    }
}
