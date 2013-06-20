//package com.skplanet.webhello.myboard.controller;
//
//import myboard.repository.BoardDBRepository;
//import myboard.repository.BoardRepository;
//
//import javax.servlet.RequestDispatcher;
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
// * Time: 오후 7:06
// * To change this template use File | Settings | File Templates.
// */
//public class BoardUpdateFormServlet extends HttpServlet {
//    BoardRepository boardRepository = BoardDBRepository.getInstance();
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(!boardRepository.isLogin(request)){
//            response.sendRedirect("/board/login");
//        }
//        int id = Integer.parseInt(request.getParameter("id"));
//        request.setAttribute("board",boardRepository.matchingId(id));
//        RequestDispatcher view = request.getRequestDispatcher("/board/boardUpdate.jsp");
//        view.forward(request, response);
//
//    }
//}
