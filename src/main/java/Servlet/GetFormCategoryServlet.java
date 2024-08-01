package Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name="GetFormCategory", urlPatterns = "/getFormCategory")
public class GetFormCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/formCategory.jsp").forward(request, response);
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//         throws ServletException, IOException{
//            request.setAttribute("category1", "Histoire");
//            request.setAttribute("category2", "Sciences fiction");
//            request.getRequestDispatcher("/WEB-INF/views/formCategory.jsp").forward(request, response);
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//        request.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request, response);
//    }
}