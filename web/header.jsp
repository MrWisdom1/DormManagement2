<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/22
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        #header{
            height: 150px;
            background: url(img/xingkong-010.jpg);
        }
        #header h1{
            color: white;
            margin-left: 200px;
            padding-top: 50px;
        }
        #user{
            font-size: 18px;
            font-weight: bold;
            margin-left: 70%;
            color: white;
        }
    </style>
</head>
<body>
<div id="header">
    <h1>橙汁校园宿舍管理系统</h1>
    <span id="user">用户：【${session_user.userName}】</span>
</div>
</body>
</html>
