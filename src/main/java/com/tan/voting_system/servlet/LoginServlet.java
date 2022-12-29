package com.tan.voting_system.servlet;

import com.tan.voting_system.pojo.User;
import com.tan.voting_system.pojo.VotingThemes;
import com.tan.voting_system.service.impl.UserService;
import com.tan.voting_system.service.impl.impl.UserServiceImpl;
import com.tan.voting_system.utils.BaseServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author TanShan
 * @date 2022/12/28 13:30
 */
@WebServlet("/login")
public class LoginServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

   public void register(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String s = userService.CreateUser(username, password);
       response.getWriter().write(s);
       request.getRequestDispatcher("login.jsp").forward(request,response);
   }

   public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
       String username = request.getParameter("username");
       String password = request.getParameter("password");

       User login = userService.Login(username, password);
       if (login != null){
           response.addCookie(new Cookie("name",login.getUsername()));
           response.addCookie(new Cookie("userid",login.getId()+""));
           request.getRequestDispatcher("home.jsp").forward(request,response);
       }else {
           request.getRequestDispatcher("login.jsp").forward(request,response);
       }

   }


}
