<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="/security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录</h1>
    <security:guest>
        <form id="login_form">
            账号:<input type="text" name="username" /><br/>
            密码:<input type="password" name="password" /><br/>
            <button type="submit" >登录</button>
        </form>
    </security:guest>
    <security:user>
        <c:redirect url="${BASE}/"/>
    </security:user>
    <script src="${BASE}/asset/jquery-3.5.1.min.js"></script>
    <script src="${BASE}/asset/jquery.form.js"></script>
    <script>
        $(function (){
            $("#login_form").ajaxForm({
                type:"post",
                url:"/login",
                success:function (res) {
                    if(res.code==0){
                        location.href="${BASE}/index";
                    }else{
                        location.reload();
                    }
                }
            })
        })
    </script>
</body>
</html>
