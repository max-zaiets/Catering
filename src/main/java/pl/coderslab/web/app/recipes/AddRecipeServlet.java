package pl.coderslab.web.app.recipes;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/app/recipe/add")
public class AddRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/app/recipes/app-add-recipe.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer adminId = (Integer) session.getAttribute("adminId");


        RecipeDao recipeDao = new RecipeDao();
        String name = req.getParameter("name");
        String ingredients = req.getParameter("ingredients");
        String description = req.getParameter("description");
        int preparationTime = Integer.parseInt(req.getParameter("preparationTime"));
        String preparation = req.getParameter("preparation");



        Recipe recipe = new Recipe(name, ingredients,description,preparationTime,preparation);
        recipe.setAdminID(adminId);

        recipeDao.create(recipe);

        resp.sendRedirect("/app/recipes");

    }
}
