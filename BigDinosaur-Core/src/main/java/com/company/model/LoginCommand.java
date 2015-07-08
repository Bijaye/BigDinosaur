package com.company.model;


public class LoginCommand {

    private String identity;

    private String password;

    private boolean rememberMe;
 
    
    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

   
    
    
}
