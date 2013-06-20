//package com.skplanet.webhello.myboard.controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.*;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * User: skplanet
// * Date: 13. 3. 7.
// * Time: 오후 3:40
// * To change this template use File | Settings | File Templates.
// */
//public class BoardLoginServlet extends HttpServlet{
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String userId = request.getParameter("userId");
//        Cookie cookie = new Cookie("userId",userId);
//        if(request.getParameter("checked")!=null){
//            cookie.setMaxAge(60*60*24*30);
//            response.addCookie(cookie);
//        }
//        else{
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
//        }
//        if(request.getParameter("userId").equals("a") && request.getParameter("passWord").equals("b")){
//            System.out.println("1");
//            HttpSession session = request.getSession();
//            session.setAttribute("userId",userId);
//            if(request.getServletContext().getAttribute("connect")==null){
//                request.getServletContext().setAttribute("connect",new Integer(0));
//            }
//            int connect = (Integer)request.getServletContext().getAttribute("connect")+1;
//            request.getServletContext().setAttribute("connect",new Integer(connect));
//        }
//        response.sendRedirect("/board/list");
//
//    }
//}
