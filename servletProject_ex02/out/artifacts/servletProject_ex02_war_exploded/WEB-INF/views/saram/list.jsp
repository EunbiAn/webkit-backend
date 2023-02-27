<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 82103
  Date: 2023-02-27
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--servlet에서 forward 되는 JSP 페이지는 response, requsest 객체가 전달되므로
해당 Servlet 페이지 내부에서 처리되는 것과 같다--%>
<h1>사람 목록 페이지~</h1>
<%--JSP에서 사용 가능한 표현식: expression, EL, JSTL 등--%>
<%--${username} : EL 문법 --%>
<%--정수, 문자열, 객체, 컬렉션 리스트 등 전달 가능 --%>
<p>안녕하세요, ${username}님!</p>
<%--JSP에서 기본 제공되는 내장 객체
 pageContext, request, response, session, application
 선언하지 않고 바로 사용 가능--%>
<p>안녕하세욤, <%= request.getAttribute("username") %></p>

<hr/>

<%
    ArrayList<String> userList= (ArrayList<String>) request.getAttribute("userList");
    PrintWriter outs = response.getWriter();
    for(String user : userList){
        outs.println(user + "<br/>");

    }
%>
</body>
</html>
