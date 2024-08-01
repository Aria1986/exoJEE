package Servlet;

import DAO.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCategory")
public class GetCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            CategoryDao categoryDao = new CategoryDao();
            request.setAttribute("category", categoryDao.getCategory(id));
            request.getRequestDispatcher("WEB-INF/views/category.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
