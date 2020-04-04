package pl.coderslab.web.app.plans;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/delete/confirm")
public class SchedulesConfirmDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("planId"));
        req.setAttribute("planId",id);

        getServletContext().getRequestDispatcher("/views/app/plans/app-confirm-delete.jsp").forward(req, resp);
    }
}