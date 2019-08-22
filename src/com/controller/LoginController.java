package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hx
 * @date 2019-08-22 11:24
 */
public class LoginController extends HttpServlet {

    protected static final String NAME = "huangxin";
    protected static final String PASSWORD="123";

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.请求参数支持中文编码 req.setCharacterEncoding("UTF-8");
        // 2.响应的支持中文编码 resp.setCharacterEncoding("UTF-8");
        // 1.接收请求的参数

        // 注意事项：req.getParameter("参数名")的参数名必须和表单（<input name="username" > ）的 name 一一对应！！
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("登录名："+username+"，密码："+password);
        //通过响应重定向到 login.html
        // 注意事项：重定向，只能通过路径参数传递值
        if (NAME.equals(username)&&PASSWORD.equals(password)){
            resp.sendRedirect(req.getContextPath()+"/to_login1？msg=登录成功");

        }else {

            resp.sendRedirect(req.getContextPath() + "/to_login?msg=登录失败");
        }
            //问题：如果不想使用路径传参数，我们希望将 request 对象交个下个跳转的 servlet 呢？
            // 既然传递过去的是一个请求，那么我们可以将数据存储在 req 对象里面

//    } req.setAttribute("msg", "登录失败");
//        req.getRequestDispatcher("/to_login").forward(req, resp);

    }

}
