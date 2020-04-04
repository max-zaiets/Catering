package pl.coderslab.web.app.users;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/app/user/data")
public class EditUserDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        Integer adminId = (Integer) session.getAttribute("adminId");

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.read(adminId);


        req.setAttribute("admin", admin);
        req.getServletContext().getRequestDispatcher("/views/app/users/app-edit-user-data.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer adminId = (Integer) session.getAttribute("adminId");
        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.read(adminId);


        admin.setFirst_name(req.getParameter("firstName"));
        admin.setLast_name(req.getParameter("lastName"));
        admin.setEmail(req.getParameter("email"));
        adminDAO.update(admin);

        resp.sendRedirect("/app/dashboard");
    }
}
