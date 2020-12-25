<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/25
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加宿舍楼</title>
</head>
<style type="text/css">
    *{
        margin: 0;
        padding: 0;
    }
    .add_build{
        width: 90%;
        border: 1px solid #CCCCCC;
        border-radius: 5px;
        margin: 50px auto;
    }
    .add_title{
        width: 95%;
        padding: 20px 10px;
        margin: 0 auto;
        border-bottom: 1px solid #CCCCCC;
    }
    .build_deal{
        width: 500px;
        height: 400px;
        margin: 100px auto;
    }
    .dorm_name{
        width: 260px;
        height: 40px;
        border-radius: 5px;
    }
    .content{
        width: 260px;
        height: 210px;
        border-radius: 5px;
    }
    .btn_keep{
        width: 50px;
        height: 30px;
        cursor: pointer;
        margin: 20px 20px;
        background: #3498db;
        border: 2px solid #3498db;
        color: white;
        border-radius: 5px;
        font-size: 14px;
        font-weight: bold;
        position: relative;
    }
    .btn_keep::before,.btn_keep::after{
        content: "";
        position: absolute;
        width: 14px;
        height: 2px;
        background: white;
        transform: skewX(50deg);
        transition: .4s linear;
    }
    .btn_keep::before{
        top: -2px;
        left: 10%;
    }
    .btn_keep::after{
        bottom: -2px;
        right: 10%;
    }
    .btn_keep:hover::before{
        left: 80%;
    }
    .btn_keep:hover::after{
        right: 80%;
    }
    #error{
        color: red;
    }
</style>
<script type="text/javascript">
    function checkForm() {
        var name = document.getElementById("build_name").value;
        if (name == null || name == ""){
            document.getElementById("error").innerHTML = "宿舍名称不能为空！";
            return false;
        }
        return true;
    }
    function fanhui() {
        window.location = "build.jsp";
    }
</script>
<body>
<div class="add_build">
    <div class="add_title">
        <h3>添加宿舍楼</h3>
    </div>
    <form action="addBuild.action" method="post" onsubmit="return checkForm()">
        <div class="build_deal">
            <input type="hidden" id="build_id" name="build_id">
            <table border="0" cellspacing="25" cellpadding="">
                <tr>
                    <td>名称：</td>
                    <td><input type="text" id="build_name" name="build_name" placeholder="请输入宿舍楼名称!" class="dorm_name"/></td>
                    <td><span id="error">${error}</span></td>
                </tr>
                <tr>
                    <td>简介：</td>
                    <td><textarea rows="20" cols="30" class="content" id="content_text" name="content_text">请输入内容...</textarea></td>
                </tr>
            </table>
            <div align="center">
                <input type="submit" class="btn_keep" value="保存"/>
                <button type="button" class="btn_keep" onclick="fanhui()">返回</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
