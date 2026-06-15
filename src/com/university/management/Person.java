package com.university.management;
public class Person {
    protected String userId;
    protected String userName;
    protected String Email;
    protected String Password;

    Person(String userId,String userName, String Email, String Password){
        this.userId = userId;
        this.userName = userName;
        this.Email = Email;
        this.Password = Password;
    }
    public String getEmail(){
        return Email;
    }
    public String getPassword(){
        return Password;
    }
    public void displayInfo(){
        System.out.println("User Name: " +userName);
        System.out.println("User Id: " +userId);
    }
    public void setUserName(String newUserName){
        this.userName = newUserName;
    }
}
