//package com.skplanet.webhello.myboard.controller;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * User: skplanet
// * Date: 13. 3. 7.
// * Time: 오후 3:28
// * To change this template use File | Settings | File Templates.
// */
//public class BoardLoginFormServlet extends HttpServlet{
//    //BoardRepository boardRepository = BoardMemoryRepository.getInstance();
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        RequestDispatcher view = request.getRequestDispatcher("/board/boardLogin.jsp");
//        Cookie[] cookies = request.getCookies();
//        String userId=null;
//        for(int i = 0; i< cookies.length;i++){
//            Cookie cookie = cookies[i];
//            if(cookie.getName().equals("userId")){
//            userId = cookie.getValue();
//            break;
//              }
//          }

//
//        int connect = (Integer)request.getServletContext().getAttribute("connect");
//
//        request.getServletContext().setAttribute("connect",new Integer(connect));
//
//        request.setAttribute("userId",userId);
//
//        request.setAttribute("connect",new Integer(connect));
//        view.forward(request, response);
//
//    }
//}
