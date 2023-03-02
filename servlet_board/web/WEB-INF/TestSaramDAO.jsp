<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="org.comstudy.myweb.model.SaramDTO" %>
<%@ page import="org.comstudy.myweb.model.SaramDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: 82103
  Date: 2023-03-02
  Time: 오전 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    SaramDAO dao = new SaramDAO();

    public void testFindAll(JspWriter out) throws IOException {
        List<SaramDTO> list = dao.findAll();
        out.println(list);
    }
%>
<%
    // inset 테스트
//  SaramDTO dto = new SaramDTO(0,"kang","강감찬",21);
//  dao.save(dto);
    // delete 테스트

    testFindAll(out);
%>
</body>
</html>
