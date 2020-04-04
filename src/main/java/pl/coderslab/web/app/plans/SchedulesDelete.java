package pl.coderslab.web.app.plans;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/plan/delete")
public class SchedulesDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlanDao plan = new PlanDao();
        int id = Integer.parseInt(req.getParameter("id"));
        plan.delete(id);
        getServletContext().getRequestDispatcher("/app/plan/list").forward(req, resp);
    }
}