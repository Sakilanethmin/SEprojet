package com.university.management;
public class Person {
    protected String userId;
    protected String userName;
    protected String email;
    protected String password;

    public Person(String userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void setUserName(String newUserName){
        this.userName = newUserName;
    }
}
