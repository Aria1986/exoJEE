package Servlet;
import DAO.BDD;
import Entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/postCategoryForm")
public class PostCategoryServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Récupération des paramètres
        String nom = request.getParameter("nomCategory");
        String description = request.getParameter("description");
        Category category = new Category(nom, description);
        BDD bdd = new BDD();
        request.setAttribute("category", category);
        request.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request, response);
    }
}
