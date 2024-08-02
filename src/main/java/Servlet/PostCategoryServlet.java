package Servlet;
import DAO.BDD;
import DAO.CategorieDao;
import DAO.CategoryDao;
import Entity.Categorie;
import Entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/postCategoryForm")
public class PostCategoryServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    //Récupération des paramètres
                    String nom = request.getParameter("nomCategory");
                    Categorie categorie = new Categorie(nom);
                    CategorieDao categorieDao = new CategorieDao();
                    request.setAttribute("category", categorie);
                    request.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request, response);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

    }



//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            //Récupération des paramètres
//            String nom = request.getParameter("nomCategory");
//            String description = request.getParameter("description");
//            CategoryDao categoryDao = new CategoryDao();
//            request.setAttribute("category", categoryDao.createCategory(nom, description));
//            request.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request, response);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
