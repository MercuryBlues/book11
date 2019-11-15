package com.rq.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String username = (String) request.getSession().getAttribute("username");
        if (username != null)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
