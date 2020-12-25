package com.servlet;

import com.bean.Build;
import com.service.BuildService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addBuild.servlet",urlPatterns = "/addBuild.action")
public class AddBuildServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8"); //设置编码，只针对POST提交有效
        //调用build服务层
        BuildService buildService = new BuildService();
        //获取宿舍名称与备注
        String build_name = req.getParameter("build_name");
        String content_text = req.getParameter("content_text");

        //宿舍楼名字不能重复，从数据库查询，当前用户输入的宿舍楼名字是否已经存在
        Build build = buildService.findByName(build_name);
        if (build != null){
            //当前用户输入的宿舍褛名已存在
            req.setAttribute("error","当前宿舍楼已存在，请重新输入！！！");
            req.getRequestDispatcher("build_add.jsp").forward(req,resp);
        }else {
            //当前用户输入的宿舍楼名不存在，则保存用户输入的信息到数据库
            Build build1 = new Build();
            build1.setBuildName(build_name);
            build1.setRemarks(content_text);
            buildService.saveBuild(build1);
            req.getRequestDispatcher("showBuild.action").forward(req,resp);
        }
    }
}
