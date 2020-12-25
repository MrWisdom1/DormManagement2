<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/18
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        body {
            text-align: center;
            background-image: url("img/login.jpg");
        }

        #login {
            float: left;
            width: 400px;
            height: 440px;
            margin-top: 360px;
            margin-left: 820px;
            background-color: #FCFCFC;
            border: black solid 1px;
            border-radius: 5px;
        }

        #big {
            margin: 0 auto;
            width: 1920px;
            height: 1080px;
            background-color: #CCC;
            background-image: url("img/login.jpg");
            background-size: cover;
        }

        img {
            margin-top: 40px;
        }

        div tr.del {
            float: left;
            width: 240px;
            margin-left: 80px;
            padding-bottom: 5px;
        }

        div tr.pass {
            width: 240px;
            float: left;
            margin-left: 80px;
            margin-bottom: 5px;
        }

        h2 {
            line-height: 40px;
        }

        div tr.al {
            float: left;
            margin-left: 120px;
            margin-top: 10px;
        }

        a:link {
            text-decoration: none;
            color: black;
        }

        a:hover {
            color: #00CCFF;
            text-decoration: underline;
        }

        a:visited {
            color: black;
        }

        div tr.jizhu {
            float: left;
            margin-left: 140px;
        }
    </style>
    <script type="text/javascript">
        function formcommit() {
            //获取用户输入的账号
            var loginNameObj =  document.getElementById("loginCode");
            //获取用户输入的密码
            var passwordObj =  document.getElementById("passWord");
            if (!/^[0-9]{11}$/.test(loginNameObj.value)) {
                document.getElementById("mess").innerHTML = "账号格式不正确！！！";
                return false;
            }
            if (!/^[a-zA-Z0-9]{5,12}$/.test(passwordObj.value)){
                document.getElementById("mess").innerHTML= "密码格式不正确！！！";
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="big">
    <div id="login">
        <div>
            <img src="img/5.png" width="80" height="65">
        </div>
        <h2>欢迎登录宿舍管理系统</h2>
        <form action="login.action" method=get id="loginForm" onsubmit="return formcommit()">
            <table>
                <tbody>
                <tr class="del">
                    <td>账号：</td>
                    <td><input style="width: 160px; height: 26px" name=loginCode id="loginCode" placeholder="请输入学号或工作号！"></td>
                </tr>
                <tr class="pass">
                    <td>密码：</td>
                    <td><input style="width: 160px; height: 26px" type=password name=passWord id="passWord" placeholder="请输入密码！">
                    </td>
                </tr>
                <tr class="jizhu">
                    <td>
                        <input type="checkbox" name="remember" id="remember" value="remember-me" class="custom-control-input">
                        <label for="remember" class="custom-control-label">记住我</label>
                    </td>
                </tr>
                <tr class="al">
                    <td>
                        <input type=submit value=登陆 style="width: 60px;height: 30px;cursor: pointer;background-color: #00CCFF;">
                        <input type=reset value=重置 style="width: 60px;height: 30px">
                    </td>
                </tr>
                </tbody>
            </table>
            <div>
                <span style="color: red;" id="mess">${mess}</span>
            </div>
        </form>
    </div>
</div>
</body>
</html>
