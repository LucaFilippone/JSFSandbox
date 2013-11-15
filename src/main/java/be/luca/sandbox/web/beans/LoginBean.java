/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;

/**
 *
 * @author Luca
 */
@Named
@SessionScoped
public class LoginBean implements Serializable{
    
    private static final String INDEX_PAGE_REDIRECT="/index.xhtml?faces-redirect=true";
    
    private String username;

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return INDEX_PAGE_REDIRECT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
