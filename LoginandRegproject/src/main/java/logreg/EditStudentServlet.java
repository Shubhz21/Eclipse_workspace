package logreg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Loginandregdao loginandregdao;

    public void init() {
        loginandregdao = new Loginandregdao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Adminandstudentmodel student = loginandregdao.getStudentById(id);
            request.setAttribute("student", student);
            request.getRequestDispatcher("edit_student.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
