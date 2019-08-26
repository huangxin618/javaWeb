package day42;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hx
 * @date 2019-08-26 19:45
 */
@WebServlet(name = "DemoLoginServlet", urlPatterns = "/demo")
public class DemoLoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("count", 0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("123")) {
            ServletContext servletContext = request.getServletContext();
            System.out.println("应用上下文："+servletContext);
            Integer count = (Integer) request.getAttribute("count");
            if (count == 0) {
                count = 1;
                request.setAttribute("count", count);
            } else {

                request.setAttribute("count", ++count);
            }
            response.sendRedirect(request.getContextPath() + "/show");
        }
    }
}
