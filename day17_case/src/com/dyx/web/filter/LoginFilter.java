package com.dyx.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(value = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 1. 强转
        HttpServletRequest request = (HttpServletRequest) req;
        // 2. 获取 请求资源 路径
        String uri = request.getRequestURI();


        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")
                || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/js/")
                || uri.contains("/checkCodeServlet")){
            //用户访问登陆资源，放行
            chain.doFilter(request, resp);
        }else{
            Object user = request.getSession().getAttribute("user");
            //已经登录，放行
            if(user!=null){
                chain.doFilter(request, resp);
            }else{

                //未登录，跳转
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);


            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
