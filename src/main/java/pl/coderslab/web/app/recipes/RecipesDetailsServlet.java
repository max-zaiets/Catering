package pl.coderslab.web.app.recipes;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/recipe/details")
public class RecipesDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        RecipeDao recipeDao = new RecipeDao();

        Recipe recipe = recipeDao.read(id);

        req.setAttribute("recipe", recipe);

        getServletContext().getRequestDispatcher("/views/app/recipes/app-recipe-details.jsp").forward(req, resp);
    }
}
