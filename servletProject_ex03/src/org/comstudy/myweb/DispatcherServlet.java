package org.comstudy.myweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DispatcherServlet", value = "/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() - DispatcherServlet 요청");


        String viewName = "/WEB-INF/views/saram/list.jsp";
        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);
    }
}
