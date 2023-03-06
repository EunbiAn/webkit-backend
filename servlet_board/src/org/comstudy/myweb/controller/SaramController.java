package org.comstudy.myweb.controller;

import org.comstudy.myweb.model.SaramDAO;
import org.comstudy.myweb.model.SaramDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaramController implements Controller {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // String으로 다운 캐스팅
        String path = (String)req.getAttribute("path");

        SaramDAO dao = new SaramDAO();
        String viewName = "/WEB-INF/views/home.jsp";
        if(path.indexOf("/input.do") != -1) {
            viewName = "/WEB-INF/views/saram/input.jsp";
        } else if(path.indexOf("/detail.do") != -1) {
            viewName = "/WEB-INF/views/saram/detail.jsp";
        } else if(path.indexOf("/modify.do") != -1) {
            SaramDTO dto = new SaramDTO();
            dto.setSeq(Integer.parseInt(req.getParameter("seq")));
            SaramDTO saram = dao.findOne(dto);
            req.setAttribute("saram",saram);
            viewName = "/WEB-INF/views/saram/modify.jsp";
        } else {
            List<SaramDTO> list = dao.findAll();
            req.setAttribute("list", list);
            viewName = "/WEB-INF/views/saram/list.jsp";
        }
        return viewName;

    }
}