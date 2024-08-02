package Servlet;

import DAO.UserDao;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/postUser")
public class PostUserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String pwdConfirm = request.getParameter("pwdConfirm");
        User user;
        if(pwd.equals(pwdConfirm)) {
            if (request.getParameter("email") != null) {
                String email = request.getParameter("email");
                user = new User(name, pwd, email);
            } else {
                user = new User(name, pwd);
            }
            UserDao userDao = new UserDao();
            userDao.save(user);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/views/user.jsp").forward(request,response);
        }
        else{
            request.setAttribute("msg", "erreur, le mdp de confirmation ne correspond pas au mdp");
            request.getRequestDispatcher("/WEB-INF/views/formCreateUser.jsp").forward(request,response);
        }
    }
}
