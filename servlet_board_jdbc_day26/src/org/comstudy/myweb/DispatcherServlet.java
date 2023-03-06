package org.comstudy.myweb;

import org.comstudy.myweb.controller.BoardController;
import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.SaramController;
import org.comstudy.myweb.model.SaramDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() - DispatcherServlet 요청");

        // path 만들기
        String ctxPath = req.getContextPath();
        String reqUri = req.getRequestURI();
        int beginIndex = ctxPath.length();
        String path = reqUri.substring(beginIndex);
        System.out.println("path >>>> " + path);
        // 하위 컨트롤러에서 path를 사용하도록 req에 저장
        req.setAttribute("path", path);

        //String viewName = new BoardController().process(req, resp);
        //String viewName = new SaramController().process(req, resp);
        Controller controller = new BoardController(); // 업캐스팅
        if(path.indexOf("/saram") != -1) {
            controller = new SaramController();
        } else if(path.indexOf("/board") != -1) {
            controller = new BoardController();
        }
        String viewName = controller.process(req, resp);

        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age")==null?"0":req.getParameter("age"));
        SaramDTO saramDTO = new SaramDTO(0, id, name, age);
        System.out.println(saramDTO);
        resp.sendRedirect("/saram/list.do");
    }

}
