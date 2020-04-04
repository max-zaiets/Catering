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
import java.util.Iterator;
import java.util.List;

@WebServlet ("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        getServletContext().getRequestDispatcher("/views/registration.jsp").forward(req, resp);
        getServletContext().getRequestDispatcher("/views/login").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");

        Admin admin = new Admin(name, surname, email, password, 0, true);
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> adminsList = adminDAO.findAll();
        Iterator<Admin> iterator = adminsList.iterator();

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("admin", admin);
        String sendRedirect = "/views/registration.jsp";

        boolean emailExist = false;
        if(name.equals("") || surname.equals("") || email.equals("") || password.equals("")){

            String message ="Żadne pole nie może być puste";
            req.setAttribute("message", message);
            sendRedirect = "/views/registration.jsp";

        }else {
            if (password.equals(repassword)) {
                while (iterator.hasNext()) {
                    if (iterator.next().getEmail().equals(email)) {
                        emailExist = true;
                    }
                }
                if (!emailExist) {
                    adminDAO.create(admin);
                    String message ="dodano użytkownika, możesz się teraz zalogować";
                    req.setAttribute("message", message);
                    sendRedirect = "/views/login.jsp";
                } else {
                    String message ="Urzytkownik z takim e-mailem już istnieje";
                    req.setAttribute("message", message);
                    sendRedirect = "/views/registration.jsp";
                }

            } else {
                String message ="podane hasła nie są identyczne!";
                req.setAttribute("message", message);
            }
        }
        req.getServletContext().getRequestDispatcher(sendRedirect).forward(req,resp);
    }


}
