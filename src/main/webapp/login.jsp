<%--
  Created by IntelliJ IDEA.
  User: FLC
  Date: 2018/8/24
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>小型进销存管理系统--登录</title>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>

    <script type="text/javascript">
        jQuery.noConflict();
        function check() {
            var flag=true;
            if(jQuery("[name=userName]").val().trim()==""||jQuery("[name=userName]").val().trim()==null)
            {
                alert("用户名必填！");
                return flag=false;
            }
            if(jQuery("[name=password]").val().trim()==""||jQuery("[name=password]").val().trim()==null)
            {
                alert("密码必填！");
                return flag=false;
            }
            return flag;

        }
    </script>
</head>
<body>
<div align="center">
    <h1>小型进销存系统</h1>
    <form action="/user/login" method="post" onsubmit="return check()">
        用户名：<input type="text" name="userName" placeholder="请输入用户名"/>
        <br/>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="请输入密码"/>
        <br/>
        <input type="submit" value="登录"/>
    </form>
</div>
</body>
</html>
