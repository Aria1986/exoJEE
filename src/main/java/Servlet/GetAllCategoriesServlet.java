package Servlet;

import DAO.CategoryDao;
import Entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/getAllCategories")
public class GetAllCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CategoryDao categoryDao = new CategoryDao();
            req.setAttribute("listCategories", categoryDao.getAllCategories());
            req.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//        Category category1 = new Category("nom1", "em bla blaie ifhfhef hhefuef gfzeifg eifzefz");
//        Category category2 = new Category("nomy2", "em bla blaie ifhfhef hhefuef gfzeifg eifzefz");
//        Category category3 = new Category("nom3", "em bla blaie ifhfhef hhefuef gfzeifg eifzefz");
//        Category category4 = new Category("nom4", "em bla blaie ifhfhef hhefuef gfzeifg eifzefz");
//        ArrayList <Category> listCategories = new ArrayList<Category>();
//        listCategories.add(category1);
//        listCategories.add(category2);
//        listCategories.add(category3);
//        listCategories.add(category4);

//        req.setAttribute("category1", category1);
//        req.setAttribute("category2", category2);
//        req.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(req, resp);
//    }
}
