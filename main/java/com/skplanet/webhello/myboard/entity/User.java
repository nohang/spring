package com.skplanet.webhello.myboard.entity;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 20.
 * Time: 오전 10:00
 * To change this template use File | Settings | File Templates.
 */
public class User {
    public User(){}
    private String name;
    private String userid;
    private String pw;
    private String nickname;
    public User(String name, String userid, String pw, String nickname){
        this.name = name;
        this.userid = userid;
        this.pw = pw;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
