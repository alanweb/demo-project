<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="/security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h1>首页</h1>
    <security:guest>
        <p>身份：游客</p>
        <a href="<c:url value="/login"/>">登录</a>
    </security:guest>
    <security:user>
        <p>身份：<security:principal/></p>
        <a href="<c:url value="/customer"/>">客户管理</a>
        <a href="<c:url value="/logout"/>">注销</a>
    </security:user>
</body>
</html>
