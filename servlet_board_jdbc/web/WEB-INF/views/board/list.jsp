<%@ page import="org.comstudy.myweb.model.BoardDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 82103
  Date: 2023-02-28
  Time: 오전 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>홈페이지</h3>
<h1>게시판 목록</h1>

<%--<table>--%>
<%--    <th>--%>
<%--        <tr>번호</tr>--%>
<%--        <tr>게시글</tr>--%>
<%--        <tr>날짜</tr>--%>
<%--        <tr>작성자</tr>--%>
<%--        <tr>조회수</tr>--%>
<%--    </th>--%>

<%
    ArrayList<BoardDTO> list = (ArrayList< BoardDTO>)request.getAttribute("list");
    for(BoardDTO board : list) {
//        out.println("<tr> <td>"+ board.getSeq() +"</td>");
//        out.println("<td>"+ board.getTitle() +"</td>");
//        out.println("<td>"+ board.getWriteDate() +"</td>");
//        out.println("<td>"+ board.getWriter() +"</td>");
//        out.println("<td>"+ board.getCnt() +"</td></tr>");
        out.println("<p>"+board+"</p>");
    }
%>
<%--</table>--%>
</body>
</html>
