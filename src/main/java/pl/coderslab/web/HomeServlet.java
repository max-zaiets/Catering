package pl.coderslab.web;


import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Plan;
import pl.coderslab.model.PlanItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Do not change servlet address !!!
 */
@WebServlet("/app/dashboard")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer adminId = (Integer) session.getAttribute("adminId");
        String adminFirstName = (String)session.getAttribute("adminFirstName");

        int countPlans = PlanDao.countPlan(adminId);
        request.setAttribute("countPlans", countPlans);

        int countRecipe = RecipeDao.count(adminId);
        request.setAttribute("countRecipe",countRecipe);

        PlanItem lastAddedPlan = PlanDao.lastAddedPlan(adminId);
        request.setAttribute("lastAddedPlan", lastAddedPlan);

        String day_name = lastAddedPlan.getDay_name();
        String meal_name = lastAddedPlan.getMeal_name();
        String recipe_name = lastAddedPlan.getRecipe_name();
        String recipe_description = lastAddedPlan.getRecipe_description();

        request.setAttribute("day_name", day_name);
        request.setAttribute("meal_name", meal_name);
        request.setAttribute("recipe_name", recipe_name);
        request.setAttribute("recipe_description", recipe_description);





        request.getServletContext().getRequestDispatcher("/views/app/dashboard.jsp").forward(request, response);
    }
}

