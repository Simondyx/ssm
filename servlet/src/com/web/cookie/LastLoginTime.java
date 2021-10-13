package com.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 利用cookie，获取上次登录时间
 */
@WebServlet(value = "/LastLoginTime")
public class LastLoginTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的消息体的数据格式 和 编码
        response.setContentType("text/html;charset=utf-8");


        String lastTime;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String str_date = sdf.format(date);

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {

            for (Cookie c :
                    cookies) {

                if (c.getName().equals("lastTime")) {
                    lastTime = c.getValue();
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为：" + lastTime + "<h1>");

                    c.setValue(str_date);
                    //设置cookie的存活时间
                    c.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(c);

                    break;
                }
            }

        } else {

            response.getWriter().write("欢迎首次访问");
            Cookie lastTimeCookie = new Cookie("lastTime", str_date);
            lastTimeCookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(lastTimeCookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
