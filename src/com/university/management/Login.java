package com.university.management;
public class Login {
    protected String email;
    protected String password;
    public Login(String email, String password){
        this.email = email;
        this.password = password;
    }
    public boolean checkEnter(String enteredEmail, String enterPassword){
        return email.equals(enteredEmail) && password.equals(enterPassword);
    }

    public void displayLogin(boolean result){
        if(result)
            System.out.println("Login Successful");
    }
}

