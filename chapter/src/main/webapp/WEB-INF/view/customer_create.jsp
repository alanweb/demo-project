<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2020/11/16
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理 - 创建客户</title>
</head>
<body>
    <h1>创建客户界面${user}</h1>
<form id="customer_form" enctype="multipart/form-data">
    <table>
        <tr>
            <td>客户名称：</td>
            <td><input type="text" name="name" value="${customer.name}"/></td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td><input type="text" name="contact" value="${customer.contact}"/></td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td><input type="tel" name="telephone" value="${customer.telephone}"/></td>
        </tr>
        <tr>
            <td>邮件地址：</td>
            <td><input type="text" name="email" value="${customer.email}"/></td>
        </tr>
        <tr>
            <td>照片：</td>
            <td><input type="file" name="photo" value="${customer.photo}"/></td>
        </tr>
    </table>
    <input type="submit" value="保存" />
</form>
<script src="${BASE}/chapter4/asset/jquery-3.5.1.min.js"></script>
<script src="${BASE}/chapter4/asset/jquery.form.js"></script>
<script>
    $(function () {
        $("#customer_form").ajaxForm({
            type:"post",
            url:"${BASE}/customer/create",
            success:function (res) {
                if(res){
                    location.href="${BASE}/customer";
                }
            }
        })
    })
</script>
</body>
</html>
