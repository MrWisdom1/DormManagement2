package com.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记住密码功能
 */

public class CookieUtil {

    public static void addCookie(String cookieName, int time, HttpServletRequest request, HttpServletResponse response, String loginCode, String passWord) {

        //根据保存学号和密码的cookie的名字获取cookie
        Cookie cookie = getCookieByName(request,cookieName);
        //如有该项目保存学号和密码的cookie，则更改cookie的值，如未有则新建cookie
        if (cookie != null){
            cookie.setValue(loginCode+"#"+passWord);
        }else {
            cookie = new Cookie(cookieName,loginCode+"#"+passWord);
        }

        //设置cookie的有效时间
        cookie.setMaxAge(time);
        //设置cookie的作用范围 只在当前项目范围中有效
        cookie.setPath(request.getContextPath());

        response.addCookie(cookie);
    }

    public static Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        //从request中获取当前项目的作用cookie
        Cookie[] cookies = request.getCookies();
        //遍历所有cookie.
        if (cookies != null && cookies.length >0){
            for (Cookie cookie : cookies){
                //如有该项目保存学号和密码的cookie，则更改cookie的值，如未有则新建cookie
                if (cookie.getName().equals(cookieName)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
