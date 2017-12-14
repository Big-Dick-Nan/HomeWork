package com.lanou3g.message;

public class UserMessage {

    private String  userName;
    private String  userPassWord;
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public UserMessage() {
    }

    public UserMessage(String userName, String userPassWord,String name) {
        this.userName = userName;
        this.userPassWord = userPassWord;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "userName='" + userName + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
