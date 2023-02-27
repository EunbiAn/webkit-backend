package org.comstudy.myweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "SaramController", value = "/saram")
public class SaramController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ctxPath = request.getContextPath();
        String reqUri = request.getRequestURI();
        System.out.println("doGet => 호출");
        // Request URI = Context path + file name
        System.out.printf("%s , %s\n", ctxPath, reqUri);
        int beginIndex = ctxPath.length();
        String urlPattern = reqUri.substring(beginIndex);
        System.out.println("urlPattern => "+ urlPattern);

        // view 페이지에서 사용된 변수 response에 저장
        // forward 될 때 request도 전달
        // JSP 페이지에서 request.getAttribute("username")으로 사용
        request.setAttribute("username","홍길동");

        ArrayList<String> userList = new  ArrayList<String>();
        userList.add("박길동 | 의사 | 33");
        userList.add("김길동 | 변호사 | 35");
        userList.add("최길동 | 프로그래머 | 30");
        // JSP에선 request.getAttribute("userList")로 사용할 수 있음
        request.setAttribute("userList", userList);

        // view 페이지로 forward
        // RequestDispatcher 객체를 이용한 view 페이지 forward
        String viewName = "/WEB-INF/views/saram/list.jsp"; // view 페이지의 위치
        RequestDispatcher view = request.getRequestDispatcher(viewName);
        // Forward - 현재 서블릿 페이지에서 하는 일을 뷰 JSP 페이지로 위임
        // request와 response 객체 전달함
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
