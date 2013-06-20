package com.skplanet.webhello.myboard.service;

import com.skplanet.webhello.myboard.entity.Board;
import com.skplanet.webhello.myboard.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 3. 22.
 * Time: 오후 2:44
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BoardDBService implements BoardService {


    private static BoardDBService instance = new BoardDBService();
    private String url = "jdbc:postgresql://localhost:5432/board";
    private String usr = "nohang";
    private String pwd = "1234";
    private String table = "board";
    private List<Board> boards = new ArrayList<Board>();

    public static BoardDBService getInstance() {
        return instance;
    }

    private BoardDBService(){}

    @Override
    public List<Board> getBoards() {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<Board> boards = new ArrayList<Board>();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
            preparedStatement = conn.prepareStatement("SELECT id,title,writer,pw,content FROM "+table);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Board board = new Board();
                board.setId(resultSet.getInt("id"));
                board.setTitle(resultSet.getString("title"));
                board.setWriter(resultSet.getString("writer"));
                board.setPw(resultSet.getString("pw"));
                board.setContent(resultSet.getString("content"));
                boards.add(board);
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }
        return boards;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addBoard(Board board) {
        //To change body of implemented methods use File | Settings | File Templates.
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
            preparedStatement = conn.prepareStatement("INSERT INTO "+ table+" (title,writer,pw,content) VALUES (?,?,?,?)");
            preparedStatement.setString(1,board.getTitle());
            preparedStatement.setString(2,board.getWriter());
            preparedStatement.setString(3,board.getPw());
            preparedStatement.setString(4, board.getContent());
            preparedStatement.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void deleteBoard(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
            preparedStatement = conn.prepareStatement("DELETE FROM " + table + " WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Board matchingId(int id) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Board board = new Board();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
            preparedStatement = conn.prepareStatement("SELECT id,title,writer,pw,content FROM "+table+" WHERE id = ?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                board.setId(resultSet.getInt("id"));
                board.setTitle(resultSet.getString("title"));
                board.setWriter(resultSet.getString("writer"));
                board.setPw(resultSet.getString("pw"));
                board.setContent(resultSet.getString("content"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return board;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateBoard(Board board) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
            preparedStatement = conn.prepareStatement("UPDATE "+ table+" set title=?,writer=?,pw=?,content=? WHERE id=?");
            preparedStatement.setString(1,board.getTitle());
            preparedStatement.setString(2,board.getWriter());
            preparedStatement.setString(3,board.getPw());
            preparedStatement.setString(4, board.getContent());
            preparedStatement.setInt(5, board.getId());
            preparedStatement.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isLogin(HttpServletRequest request){
        if(request.getSession().getAttribute("userid")!=null) return true;
        else return false;
    }
    @Override
    public String getUserId(HttpServletRequest request){

        return null;

    }


}
