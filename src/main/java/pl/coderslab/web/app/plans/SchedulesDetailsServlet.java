package pl.coderslab.web.app.plans;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Plan;
import pl.coderslab.model.PlanItem;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;


@WebServlet(urlPatterns = "/app/plan/details")
public class SchedulesDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        HttpSession httpSession = req.getSession(true);
        Integer adminId = (Integer) httpSession.getAttribute("adminId");

        PlanDao planDao = new PlanDao();
        Plan plan = planDao.readPlan(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("plan", plan);

        List<Plan> planByAdmin = planDao.findAllByUser(adminId);
        req.setAttribute("planByAdmin", planByAdmin);


        List<PlanItem> planDetails = planDao.readPlanDetails(plan.getId());
        httpSession.setAttribute("planDetails", planDetails);


        String planName = plan.getName();
        String description = plan.getDescription();


        req.setAttribute("planName", planName);
        req.setAttribute("description", description);



        getServletContext().getRequestDispatcher("/views/app/plans/app-details-schedules.jsp").forward(req, resp);
    }
}
