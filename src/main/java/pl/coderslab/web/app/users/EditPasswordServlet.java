package pl.coderslab.web.app.users;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.dao.AdminDAO;
import pl.coderslab.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/app/edit/password")
public class EditPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        req.getServletContext().getRequestDispatcher("/views/app/users/app-edit-password.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("newPassword");
        String repeatPassword = req.getParameter("repeatPassword");
        AdminDAO adminDAO = new AdminDAO();


        HttpSession session = req.getSession();
        Integer adminId = (Integer) session.getAttribute("adminId");
        Admin read = adminDAO.read(adminId);
        String message;

        if(newPassword.equals(repeatPassword)){
            read.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
            adminDAO.update(read);
            message="Hasło zostało zmienione";

        } else {
            message = "Podane hasła są różne";
        }

        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/views/app/users/app-edit-password-confirm.jsp").forward(req,resp);
    }
}
