package com.skplanet.webhello.myboard.service;

import com.skplanet.webhello.myboard.entity.Board;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 14.
 * Time: 오후 5:04
 * To change this template use File | Settings | File Templates.
 */
public interface BoardService {
    List<Board> getBoards();

    void addBoard(Board board);
    void deleteBoard(int id);
    Board matchingId(int id);
    void updateBoard(Board board);
    boolean isLogin(HttpServletRequest request);
    String getUserId(HttpServletRequest request);
}
