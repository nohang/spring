//package com.skplanet.webhello.myboard.controller;
//
//import myboard.entity.Board;
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
// * Time: 오후 7:06
// * To change this template use File | Settings | File Templates.
// */
//public class BoardUpdateServlet extends HttpServlet {
//    BoardRepository boardRepository = BoardDBRepository.getInstance();
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            request.setCharacterEncoding("utf-8");
//            Board board = new Board();
//            board.setId(Integer.parseInt(request.getParameter("id")));
//            board.setWriter(request.getParameter("writer"));
//            board.setTitle(request.getParameter("title"));
//            board.setPw(request.getParameter("pw"));
//            board.setContent(request.getParameter("content"));
//            boardRepository.updateBoard(board);
//            response.sendRedirect("/board/list");
//
//    }
//
//
//}
//
