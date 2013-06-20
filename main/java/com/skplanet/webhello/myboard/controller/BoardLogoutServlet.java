//package com.skplanet.webhello.myboard.controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * User: skplanet
// * Date: 13. 3. 7.
// * Time: 오후 3:47
// * To change this template use File | Settings | File Templates.
// */
//public class BoardLogoutServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        HttpSession session = request.getSession(false);
//        session.invalidate();
//        if(request.getServletContext().getAttribute("connect")==null){
//            request.getServletContext().setAttribute("connect",new Integer(0));
//        }
//        int connect = (Integer)request.getServletContext().getAttribute("connect");
//        connect--;
//        request.getServletContext().setAttribute("connect",new Integer(connect));
//        response.sendRedirect("/board/list");
//
//    }
//}
