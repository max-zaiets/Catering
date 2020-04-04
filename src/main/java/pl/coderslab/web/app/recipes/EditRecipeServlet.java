package pl.coderslab.web.app.recipes;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/recipes/edit")
public class EditRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();

        Recipe recipe = recipeDao.read(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("recipe", recipe);



        getServletContext().getRequestDispatcher("/views/app/recipes/app-edit-recipe.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        Recipe recipe = new Recipe();

        recipe.setId(Integer.parseInt(req.getParameter("id")));
        recipe.setName(req.getParameter("name"));
        recipe.setIngredients(req.getParameter("ingredients"));
        recipe.setDescription(req.getParameter("description"));
        recipe.setPreparationTime(Integer.parseInt(req.getParameter("preparationTime")));
        recipe.setPreparation(req.getParameter("preparation"));
        recipeDao.update(recipe);

        resp.sendRedirect("/app/recipes");
    }
}
