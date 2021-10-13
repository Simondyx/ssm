package com.dyx.servlet;

import com.dyx.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取 req域 中共享的对象
        User user = (User) req.getAttribute("user");

        //设置编码
        resp.setCharacterEncoding("utf-8");
        //输出在页面
        resp.getWriter().write("登陆成功，" + "欢迎你" + user.getUsername() );

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
