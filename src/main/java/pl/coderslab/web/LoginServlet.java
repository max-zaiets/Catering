package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.model.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");


        String email = req.getParameter("email");
        String password = req.getParameter("password");
        AdminDAO adminDAO = new AdminDAO();

        if (email == null || password == null) {
            String message = "Podaj email lub hasło";
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(req,resp);
            return;
        }


        Admin admin = adminDAO.check(email, password);

        if (admin != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("adminId", admin.getId());
            httpSession.setAttribute("adminFirstName", admin.getFirst_name());
        }

        resp.sendRedirect("/app/dashboard");
    }
}
