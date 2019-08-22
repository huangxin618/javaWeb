package com.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hx
 * @date 2019-08-22 17:10
 */
public class LoginUDS extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //Object msg = req.getAttribute("msg");
        PrintWriter out1 = resp.getWriter();
        out1.append("<!DOCTYPE html> ");
        out1.append("<html>");
        out1.append("<head>");
        out1.append("<meta charset='UTF-8'>");
        out1.append("<title>用户登录成功</title>");
        out1.append("</head>");
        out1.append("<body>");
        out1.append( "<form action='login' method='post'>");
        out1.append("登录成功");
        out1.append("</form>");
        out1.append("</body>");
        out1.append("</html>");
    }
}
