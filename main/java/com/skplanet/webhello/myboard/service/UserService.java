package com.skplanet.webhello.myboard.service;

import com.skplanet.webhello.myboard.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 20.
 * Time: 오전 9:59
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    List<User> getUser();
    void addUser(User user);
    boolean isSignUp(User user);
    boolean isAuth(String id,String pw);

}
