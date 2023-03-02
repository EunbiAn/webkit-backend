package org.comstudy.myweb.controller;

import org.comstudy.myweb.model.BoardDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class BoardController implements Controller{
    @Override
    public String process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
        boardList.add(new BoardDTO(1L,"tset입니당","게시글 등록 중",new Date(), "안안안",0L));
        boardList.add(new BoardDTO(2L,"또 다른 tset입니당","게시글 등록 중22",new Date(), "은은",0L));
        req.setAttribute("list", boardList);
        String viewName = "/WEB-INF/views/board/list.jsp";
        return viewName;
    }
}
