package com.Servlet;

import com.Service.UserService;
import com.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hx
 * @date 2019-08-23 15:35
 */
//@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet1 extends HttpServlet {

    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User login = userService.login(username,password);

        if (login !=null){
            request.setAttribute("user",login);
            request.getRequestDispatcher("/succss").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/failure");
        }

    }

}
