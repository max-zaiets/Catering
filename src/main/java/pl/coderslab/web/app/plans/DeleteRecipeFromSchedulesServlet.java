package pl.coderslab.web.app.plans;

import pl.coderslab.dao.RecipeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/app/plan/recipes/delete")
public class DeleteRecipeFromSchedulesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        int id = Integer.parseInt(req.getParameter("id"));
        recipeDao.delete(id);
        //resp.sendRedirect("/app/plan/details");
        getServletContext().getRequestDispatcher("/app/plan/details").forward(req, resp);
    }
}
