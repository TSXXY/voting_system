<%--
  Created by IntelliJ IDEA.
  User: TS
  Date: 2022/12/27
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>默认跳转</title>
    <base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/ "/>
</head>
<body>
<jsp:forward page="login.jsp"></jsp:forward>
</body>
</html>
