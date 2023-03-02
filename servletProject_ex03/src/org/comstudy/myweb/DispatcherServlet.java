package org.comstudy.myweb;

import org.comstudy.myweb.model.BoardDTO;
import org.comstudy.myweb.model.SaramDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

//@WebServlet(name = "DispatcherServlet", value = "/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet() - DispatcherServlet 요청");

        ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
        boardList.add(new BoardDTO(1L,"tset입니당","게시글 등록 중",new Date(), "안안안",0L));
        boardList.add(new BoardDTO(2L,"또 다른 tset입니당","게시글 등록 중22",new Date(), "은은",0L));
        String viewName = "/WEB-INF/views/board/list.jsp";
        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);

    }

    protected void testSaramService (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SaramDTO saram = new SaramDTO(1, "hong", "홍길동", 25);
        req.setAttribute("saram", saram);

        ArrayList<SaramDTO> list = new ArrayList<SaramDTO>();
        list.add(new SaramDTO(2, "hong2", "홍길동2", 26));
        list.add(new SaramDTO(2, "hong3", "홍길동3", 22));
        list.add(new SaramDTO(2, "hong4", "홍길동4", 29));
        req.setAttribute("list", list);
        String viewName = "/WEB-INF/views/saram/list.jsp";
        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);
    }
}
