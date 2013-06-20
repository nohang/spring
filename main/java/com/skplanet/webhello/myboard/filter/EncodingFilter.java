package com.skplanet.webhello.myboard.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 3. 13.
 * Time: 오후 4:00
 * To change this template use File | Settings | File Templates.
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //To change body of implemented methods use File | Settings | File Templates.

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

//        System.out.println("===Encoding Filter===");
        httpServletRequest.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
