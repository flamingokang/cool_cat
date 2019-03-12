package com.flamingo.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter1")
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        //若session不为null则放行
        if(session.getAttribute("user") != null){
            chain.doFilter(request, response);
        }
        else{
            //重定向到登录页面
            httpResponse.sendRedirect("login.html");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
