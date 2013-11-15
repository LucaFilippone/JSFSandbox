/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Luca
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    private static final String USER_INFO_REDIRECT="secured/userInfo.xhtml?faces-redirect=true";
    private static final String USER_LOGIN_PAGE="../login.xhtml?faces-redirect=true";
    
    // Simple user 
     private static final String[] users = {"luca:azerty","bla:bla"}; 
    
    private String userName;
    private String password;
    
    private boolean loggedIn;
    
    public String login(){
        for(String user : users){
            String dbUsername = user.split(":")[0];
            String dbPassword = user.split(":")[1];
             
            // Successful login
            if (dbUsername.equals(getUserName()) && dbPassword.equals(getPassword())) {
                loggedIn = true;
                return USER_INFO_REDIRECT;
            }
        }
        
        return null;
    }
    
    public String logout(){
        loggedIn=false;
        
        
        Messages.addGlobalInfo("Successfully logged out "+getUserName());
        
        setUserName(null);
        setPassword(null);
        
        return USER_LOGIN_PAGE;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
}
