//package com.skplanet.webhello.myboard.controller;
//
//import myboard.repository.BoardDBRepository;
//import myboard.repository.BoardRepository;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * User: skplanet
// * Date: 13. 3. 4.
// * Time: 오후 7:04
// * To change this template use File | Settings | File Templates.
// */
//public class BoardDeleteServlet extends HttpServlet {
//    BoardRepository boardRepository = BoardDBRepository.getInstance();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      int id = Integer.parseInt(request.getParameter("id"));
//        System.out.println(id);
//        boardRepository.deleteBoard(id);
//      response.sendRedirect("/board/list");
//
//    }
//}
