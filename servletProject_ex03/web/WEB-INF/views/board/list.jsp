
<%@page import="java.util.ArrayList"%>
<%@ page import="org.comstudy.myweb.model.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h3>홈페이지</h3>
<h1>게시판 목록</h1>

<%
    ArrayList<BoardDTO> list = (ArrayList< BoardDTO>)request.getAttribute("list");
    for(BoardDTO board : list) {

        out.println("<p>"+ board +"</p>");
    }
%>

</body>
</html>