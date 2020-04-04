package pl.coderslab.web.app.plans;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/app/plan/add")
public class SchedulesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/app/plans/app-schedules.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String planName = req.getParameter("planName");
        String planDescription = req.getParameter("planDescription");
        Integer adminId = (Integer) session.getAttribute("adminId");

        PlanDao planDao = new PlanDao();
        Plan plan = new Plan(planName, planDescription, adminId);

        if (planName.equals("") || planDescription.equals("")) {
            String message = "Żadne pole nie może być puste";
            req.setAttribute("message", message);
        } else {
            planDao.create(plan);

            req.setAttribute("message", "Plan został dodany pomyślnie :)");
        }
        getServletContext().getRequestDispatcher("/views/app/plans/app-schedules.jsp").forward(req, resp);
    }
}