<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/24
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>build</title>
    <link rel="stylesheet" type="text/css" href="css/build.css"/>
    <script type="text/javascript">
        function save() {
            window.location = "build_add.jsp";
        }
    </script>
</head>
<body>
<div class="data_list">
    <div class="list_title">
        <h3>宿舍楼管理</h3>
    </div>
    <form action="" method="post">
        <button type="button" class="Add_data" onclick="save()">添加</button>
        <div class="data_search">
            <select id="build_id" name="build_id" class="dorm_search">
                <option value ="">全部宿舍楼</option>
                <option value =""></option>
            </select>
            <button type="submit" class="btn_search">搜索</button>
        </div>
    </form>
    <div class="list_deal">
        <table border="" cellspacing="0" cellpadding="">
            <tr style="width: 100%;">
                <th width="10%">序号</th>
                <th width="28%">名称</th>
                <th width="45%">简介</th>
                <th width="35%">操作</th>
            </tr>
<%--            items :表示要循环追历的元素,var :代表当前集合中每一个元素,varStatus代表循环状态的变里名--%>
            <c:forEach items="${builds}" var="build" varStatus="state">
                <tr>
                    <td>${state.index+1}</td>
                    <td>${build.buildName}</td>
                    <td>${build.remarks}</td>
                    <td>
                        <button type="button" class="btn_modify" onclick="javascript:window.location='modifyBuild.action?buildId=${build.buildId}'">修改</button>
                        <button type="button" class="btn" onclick="javascript:window.location='modifyBuild.action?buildId=${build.buildId}'">删除</button>
                        <button type="button" class="btn">激活</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
