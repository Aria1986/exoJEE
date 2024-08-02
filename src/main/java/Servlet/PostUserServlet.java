package Servlet;

import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postUser")
public class PostUserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String pwdConfirm = request.getParameter("pwdConfirm");
        User user;
        if(pwd == pwdConfirm) {
            if (request.getParameter("email") != null) {
                String email = request.getParameter("email");
                user = new User(name, pwd, email);
            } else {
                user = new User(name, pwd);
            }
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/views/user.jsp");
        }
    }
}
