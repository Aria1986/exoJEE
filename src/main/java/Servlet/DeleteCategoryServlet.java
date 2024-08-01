package Servlet;

import DAO.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        try{
            String id = req.getParameter("id");
            CategoryDao categoryDao =new CategoryDao();
            String suppression = categoryDao.supprimerCategory(id);
            if(suppression != null){
                req.setAttribute("msg",suppression);
            }
            else{
                req.setAttribute("msg","erreur la catégorie n'a pas pu être supprimée");
            }
        req.getRequestDispatcher("WEB-INF/views/categories.jsp").forward(req,res);
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
