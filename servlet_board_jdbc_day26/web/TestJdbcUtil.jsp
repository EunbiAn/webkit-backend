<%@ page import="java.sql.Connection" %>
<%@ page import="org.comstudy.myweb.dbcp.JdbcUtil" %><%--
  Created by IntelliJ IDEA.
  User: 82103
  Date: 2023-02-28
  Time: 오후 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Connection conn = JdbcUtil.getConnection();
    out.println(conn);
    JdbcUtil.close(conn);
%>
</body>
</html>
