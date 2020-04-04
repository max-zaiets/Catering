package pl.coderslab.web.app.plans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/app/plan/details/confirm")
public class ConfirmDeleteRecipeFromSchedulesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        req.setAttribute("id",id);

        getServletContext().getRequestDispatcher("/views/app/plans/app-recipe-form-schedule-confirm.jsp").forward(req, resp);
    }
}
