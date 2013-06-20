//package com.skplanet.webhello.myboard.controller;
//
//import myboard.entity.Board;
//import myboard.repository.BoardDBRepository;
//import myboard.repository.BoardRepository;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
///**
// * User: HolyEyE
// * Date: 13. 2. 22. Time: 오후 4:37
// */
//public class BoardListServlet extends HttpServlet{
//
//    BoardRepository boardRepository = BoardDBRepository.getInstance();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(!boardRepository.isLogin(request)){
////            getServletContext() sc =  event
//            System.out.println("3");
//            response.sendRedirect("/board/loginForm");
//            return;
//        }
//        System.out.println("2");
//        //1. model에서 데이터 조회
//        List<Board> boards = boardRepository.getBoards();
//
//
//
//        //2. request에 데이터 셋팅
//        request.setAttribute("boards",boards);
//
//        //3. jsp찾아서 이동
//        RequestDispatcher view = request.getRequestDispatcher("/board/boardList.jsp");
//        view.forward(request, response);
//    }
//}
