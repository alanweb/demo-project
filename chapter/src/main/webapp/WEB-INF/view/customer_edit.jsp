<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="/security" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 xxx
<security:hasAnyPermissions name="customer:edit">edit</security:hasAnyPermissions>
<security:hasAnyPermissions name="customer:list">list</security:hasAnyPermissions>
</body>
</html>
