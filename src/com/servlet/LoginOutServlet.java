package com.servlet;

import com.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginOut.action",urlPatterns = "/loginOut.action")
public class LoginOutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //清除保存在session中的用户信息
        req.getSession().removeAttribute("session_user");

        //清除保存在cookie中的用户信忌.
        //根据名字查找保存当前项目的学号和密码
        Cookie cookie = CookieUtil.getCookieByName(req,"cookie_name_pass");
        if (cookie != null){
            //设计cookie有效时间0，马上失效
            cookie.setMaxAge(0);
            cookie.setPath(req.getContextPath());
            //使用cookie一定要响应出去
            resp.addCookie(cookie);
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
