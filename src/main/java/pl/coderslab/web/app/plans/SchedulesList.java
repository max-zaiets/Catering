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
import java.util.Collections;
import java.util.List;

@WebServlet("/app/plan/list")
public class SchedulesList extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlanDao planDao = new PlanDao();
        List<Plan> plans = planDao.findAll();

        req.setAttribute("plans",plans);


        HttpSession httpSession = req.getSession();
        Integer adminId = (Integer) httpSession.getAttribute("adminId");

        List<Plan> planByAdmin = planDao.findAllByUser(adminId);
        req.setAttribute("planByAdmin", planByAdmin);
        Collections.reverse(planByAdmin);


        getServletContext().getRequestDispatcher("/views/app/plans/app-schedules-list.jsp").forward(req,resp);
    }
}