package com.servlet;

import com.bean.User;
import com.service.UserService;
import com.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.action")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过输入框的name属性获取用户输入的账号密码
        String loginCode = request.getParameter("loginCode");
        String passWord = request.getParameter("passWord");
        String remember = request.getParameter("remember");

        //调用用户的服务层
        UserService userService = new UserService();
        //查询用户学工号和密码
        User user = userService.findByCodeAndPass(loginCode,passWord);
        if (user == null){
            //提示错误信息，并跳转到登录页面
            request.setAttribute("mess","账号或密码错误！，请重新输入！");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            //保存在session中的数据，默认是30分钟内有效.保存在session中的数据,在整个项目中都可以获取得到
            request.getSession().setAttribute("session_user", user);

            if (remember != null && remember.equals("remember-me")){
                //记住密码一周
                CookieUtil.addCookie("cookie_name_pass",7*24*60*60,request,response,loginCode,passWord);
            }

            //跳转到首页
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//
//        System.out.println("大概就是这样！");
//    }
}
