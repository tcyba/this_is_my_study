package com.upload.scy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by upload on 2021/11/12.
 */
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤请求");
        //通过过滤器继续访问资源
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;chartset=UTF-8");
        System.out.println("aaaaaaaaaa");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("ada");

    }
    @Override
    public void destroy() {

        System.out.println("destory");
    }
}
