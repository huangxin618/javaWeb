package com.view;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hx
 * @date 2019-08-21 10:45
 */
public class LoginServlet extends HttpServlet {
    /*
     * doPost 用于接收请求过来的 post 请求的，method="post"
     * 参数 1：HttpServletRequest 请求对象
     * 参数 2：HttpServletResponse 响应对象
     */

    @Override
    public void init() throws ServletException {
        System.out.println("你好！世界");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1,请求参数支持中文编码
        req.setCharacterEncoding("UTF-8");
        //2.响应的支持中文编码
        resp.setCharacterEncoding("UTF-8");

        //接收请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = "admin";
        String num = "529";
        //通过 HTTpServletResponse 输出动态页面
        System.out.println("用户名：" + username + "\n" + "密码：" + password);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        if (username.equals(name) && password.equals(num)) {
            out.println("<title>登录成功页面</title>");
            out.println("<body>");
            out.println("用户名：" + username + ",密码：" + password);
        } else {
            out.println("<title>登录失败页面</title>");
            out.println("<body>");
            out.println("登录失败");
        }
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
    }
}
