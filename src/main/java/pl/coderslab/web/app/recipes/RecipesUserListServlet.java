package pl.coderslab.web.app.recipes;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/recipes")
public class RecipesUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();

        List<Recipe> recipes = recipeDao.findAll();

        req.setAttribute("recipes", recipes);

        getServletContext().getRequestDispatcher("/views/app/recipes/app-recipes.jsp").forward(req, resp);
    }
}
