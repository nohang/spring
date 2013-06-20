//package com.skplanet.webhello.myboard.filter;
//
//import myboard.wrapper.PrintingWrapper;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * User: skplanet
// * Date: 13. 3. 13.
// * Time: 오후 4:11
// * To change this template use File | Settings | File Templates.
// */
//public class PrintingFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //To change body of implemented methods use File | Settings | File Templates.
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//
////        System.out.println("===Printing Filter===");
////        System.out.println("httpServletRequestURI = " + httpServletRequest.getRequestURI());
////        System.out.println("httpServletRequestIP = " + httpServletRequest.getRemoteAddr());
//
//        PrintingWrapper printingWrapper = new PrintingWrapper(httpServletRequest);
//
//        filterChain.doFilter(printingWrapper,httpServletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//}
