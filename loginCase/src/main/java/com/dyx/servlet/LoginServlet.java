package com.dyx.servlet;

import com.dyx.dao.UserDao;
import com.dyx.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //判断登录
        if (user == null) {

            //失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {

            //存储
            req.setAttribute("user", user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}