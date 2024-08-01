package Servlet;
import DAO.BDD;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/jsp")
public class TestJSP extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        try {
            BDD bdd = new BDD();
            PrintWriter msg = response.getWriter();
            if (bdd.getConnection() != null) {
                msg.println("<html><body>connecte<html><body>");
            }
            else{
                msg.println("<html><body>non connecte<html><body>");

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
//            String message = "Ha ça y est j'y suis!";
//            request.setAttribute("message1", message);
//            request.setAttribute("message2", "Salut toi");
//            request.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(request, response);
        }

//    protected void test()
//            throws ServletException, SQLException {
//        BDD bdd = new BDD();
//        bdd.getConnection();
//        bdd.createTables();
}
