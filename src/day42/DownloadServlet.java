package day42;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author hx
 * @date 2019-08-26 20:49
 */
@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext sc = request.getServletContext();
        String realPath = null;

        if("demo.zip".equals(filename)){
            realPath = sc.getRealPath("file");
        }else{
            realPath = sc.getRealPath("img");
        }

        FileInputStream fis = new FileInputStream(realPath + File.separator+filename);

        //将文件名字符串 先还原成字节数组    再按照iso8859-1的方式组成字符串(支持中文)
        filename = new String(filename.getBytes(), "iso8859-1");
        response.setHeader("Content-Disposition","attachment;filename="+filename);

        ServletOutputStream ops = response.getOutputStream();
        IOUtils.copy(fis, ops);//输入流复制到输出流
        fis.close();
        ops.close();
    }
}
