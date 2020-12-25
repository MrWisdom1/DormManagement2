package com.servlet;


import com.bean.Build;
import com.service.BuildService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showBuild.servlet",urlPatterns = "/showBuild.action")
public class ShowBuildServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用服务层
        BuildService buildService = new BuildService();
        //查询所有宿舍楼的信息
        List<Build> builds = buildService.findAllBuild();
        req.setAttribute("builds",builds);
        //跳转到展示宿舍页面
        req.getRequestDispatcher("build.jsp").forward(req,resp);
    }
}
