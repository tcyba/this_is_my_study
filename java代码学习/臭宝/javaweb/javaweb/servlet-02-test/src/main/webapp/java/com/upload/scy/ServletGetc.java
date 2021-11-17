package com.upload.scy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by upload on 2021/11/11.
 */
public class ServletGetc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        String username = req.getParameter("username");
//
//        String username = (String) context.getAttribute("username");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html");
        resp.getWriter().println("Ãû×Ö"+username);
    }
}
