package com.Servlet;

import com.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hx
 * @date 2019-08-23 15:46
 */
public class SuccessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{

        User user =(User) request.getAttribute("user");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<h1>欢迎您，登录成功"+user.getUserName()+"</h1>");

    }

}
