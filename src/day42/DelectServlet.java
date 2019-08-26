package day42;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hx
 * @date 2019-08-26 20:13
 */
@WebServlet(name = "DelectServlet",urlPatterns = "/elect")
public class DelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext= request.getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");

        servletContext.setAttribute("count",--count);
        response.sendRedirect(request.getContextPath()+"/show");
    }
}
