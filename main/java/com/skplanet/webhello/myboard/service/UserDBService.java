package com.skplanet.webhello.myboard.service;

import com.skplanet.webhello.myboard.entity.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 20.
 * Time: 오전 9:55
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserDBService implements UserService{

    private static UserDBService instance = new UserDBService();
    private String url = "jdbc:postgresql://localhost/users";
    private String usr = "nohang";
    private String pwd = "1234";
    private String table = "users";
    public static UserDBService getInstance(){
        return instance;
    }

    private UserDBService(){}

    @Override
    public List<User> getUser() {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<User>();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
            preparedStatement = conn.prepareStatement("SELECT name,userid,pw,nickname FROM "+table);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setUserid(resultSet.getString("userid"));
                user.setPw(resultSet.getString("pw"));
                user.setNickname(resultSet.getString("nickname"));
                users.add(user);
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
        return users;
    }

    @Override
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
            preparedStatement = conn.prepareStatement("INSERT INTO "+ table+" (name,userid,pw,nickname) VALUES (?,?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getUserid());
            preparedStatement.setString(3,user.getPw());
            preparedStatement.setString(4,user.getNickname());
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
    public boolean isSignUp(User newUser) {
        List<User> users = getUser();
        for(Iterator<User> it = users.iterator(); it.hasNext();){
            User user = it.next();
            if(user.getUserid().matches(newUser.getUserid())==true){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAuth(String id,String pw) {
        List<User> users = getUser();
        for(Iterator<User> it = users.iterator(); it.hasNext();){
            User user = it.next();
            if(user.getUserid().matches(id)==true && user.getPw().matches(pw)==true){
                return true;
            }
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }



}
