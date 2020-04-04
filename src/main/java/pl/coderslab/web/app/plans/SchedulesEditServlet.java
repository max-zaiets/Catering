package pl.coderslab.web.app.plans;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/plan/edit")
public class SchedulesEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlanDao planDao = new PlanDao();

        Plan plan = planDao.readPlan(Integer.parseInt(req.getParameter("id")));

        req.setAttribute("plan", plan);


        getServletContext().getRequestDispatcher("/views/app/plans/app-edit-schedules.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlanDao planDao = new PlanDao();
        Plan plan = new Plan();
        plan.setId(Integer.parseInt(req.getParameter("id")));
        plan.setName(req.getParameter("name"));
        plan.setDescription(req.getParameter("description"));

        planDao.update(plan);

        resp.sendRedirect("/app/plan/list");
    }
}
