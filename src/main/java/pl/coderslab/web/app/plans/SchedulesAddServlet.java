package pl.coderslab.web.app.plans;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.DayName;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;
import pl.coderslab.model.RecipePlan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/recipe/plan/add")
public class SchedulesAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlanDao planDao = new PlanDao();
        HttpSession session = req.getSession();
        Integer adminId = (Integer) session.getAttribute("adminId");
        List<Plan> allPlans = planDao.findAllByUser(adminId);
        req.setAttribute("allName", allPlans);
        RecipeDao recipeDao = new RecipeDao();
        List<Recipe> allRecipe = recipeDao.findAll();
        req.setAttribute("recipe", allRecipe);
        DayNameDao dayNameDao = new DayNameDao();
        List<DayName> allDay = dayNameDao.findAll();
        req.setAttribute("day", allDay);


        getServletContext().getRequestDispatcher("/views/app/plans/addRecipeToPlan.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer planId = Integer.parseInt(req.getParameter("planId"));
        String mealName = req.getParameter("mealName");
        String mealNumber = req.getParameter("mealNumber");
        Integer recipeId = Integer.parseInt(req.getParameter("recipe_id"));
        Integer day = Integer.parseInt(req.getParameter("day"));

        RecipePlanDao recipePlanDao = new RecipePlanDao();
        RecipePlan recipePlan = new RecipePlan(planId,mealName,mealNumber,recipeId,day);
        recipePlanDao.create(recipePlan);

        PlanDao planDao = new PlanDao();
        HttpSession session = req.getSession();
        Integer adminId = (Integer) session.getAttribute("adminId");
        List<Plan> allPlans = planDao.findAllByUser(adminId);
        req.setAttribute("allName", allPlans);
        RecipeDao recipeDao = new RecipeDao();
        List<Recipe> allRecipe = recipeDao.findAll();
        req.setAttribute("recipe", allRecipe);
        DayNameDao dayNameDao = new DayNameDao();
        List<DayName> allDay = dayNameDao.findAll();
        req.setAttribute("day", allDay);

        req.setAttribute("message", "Przepis został dodany do planu pomyślnie :)");
        getServletContext().getRequestDispatcher("/views/app/plans/addRecipeToPlan.jsp").forward(req, resp);
    }
}
