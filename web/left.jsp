<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/22
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>左边导航栏</title>
</head>
<style type="text/css">
    body{
        margin: 0;
        padding: 0;
    }
    .nav{
        width: 150px;
        border: 1px solid red;
        border-radius: 5px;
        margin: 0 auto;
    }
    .nav ul{
        list-style: none;
        margin-left: -40px;
    }
    .nav ul li{
        width: 108px;
        padding-left: 40px;
        line-height: 30px;
        border: 1px solid white;
        background-color: #00CCFF;
    }
    .nav ul li a{
        text-decoration: none;
        color: white;
        font-size: 18px;
    }
</style>
<body>
<div class="nav">
    <ul>
        <%--        系统管理员--%>
        <c:if test="${session_user.userRole == 0}">
            <li><a href="first.jsp" target="content">网页首页</a></li>
            <li><a href="" target="content">管理员管理</a></li>
            <li><a href="showBuild.action" target="content">宿舍楼管理</a></li>
            <li><a href="" target="content">学生管理</a></li>
            <li><a href="" target="content">缺勤记录</a></li>
            <li><a href="" target="content">查看反馈建议</a></li>
            <li><a href="" target="content">发布公告</a></li>
            <li><a href="" target="content">修改密码</a></li>
            <li><a href="loginOut.action" target="content">退出系统</a></li>
        </c:if>
        <%--    宿舍管理员--%>
        <c:if test="${session_user.userRole == 1}">
            <li><a href="first.jsp" target="content">网页首页</a></li>
            <li><a href="" target="content">学生管理</a></li>
            <li><a href="" target="content">缺勤记录</a></li>
            <li><a href="" target="content">反馈建议</a></li>
            <li><a href="" target="content">查看公告</a></li>
            <li><a href="" target="content">修改密码</a></li>
            <li><a href="loginOut.action" target="content">退出系统</a></li>
        </c:if>
        <%--   学生--%>
        <c:if test="${session_user.userRole == 2}">
            <li><a href="first.jsp" target="content">网页首页</a></li>
            <li><a href="" target="content">查看缺勤记录</a></li>
            <li><a href="" target="content">反馈建议</a></li>
            <li><a href="" target="content">查看公告</a></li>
            <li><a href="" target="content">修改密码</a></li>
            <li><a href="loginOut.action" target="content">退出系统</a></li>
        </c:if>
    </ul>
</div>
</body>
</html>
